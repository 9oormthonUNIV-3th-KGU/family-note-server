package goorm.kgu.familynote.domain.login.application;

import java.time.Duration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.common.auth.jwt.TokenProvider;
import goorm.kgu.familynote.domain.login.domain.RefreshToken;
import goorm.kgu.familynote.domain.login.infrastructure.RefreshTokenRepository;
import goorm.kgu.familynote.domain.login.presentation.exception.InvalidPasswordException;
import goorm.kgu.familynote.domain.login.presentation.exception.TokenNotFoundException;
import goorm.kgu.familynote.domain.login.presentation.request.LoginRequest;
import goorm.kgu.familynote.domain.login.presentation.request.RefreshTokenRequest;
import goorm.kgu.familynote.domain.login.presentation.response.AccessTokenResponse;
import goorm.kgu.familynote.domain.login.presentation.response.LoginSucceedResponse;
import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final RefreshTokenRepository refreshTokenRepository;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;

	@Transactional
	public LoginSucceedResponse login(LoginRequest request) {
		String nickname = request.nickname();
		String password = request.password();

		User user = userService.getUserByNickname(nickname);
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new InvalidPasswordException();
		}

		String refreshToken = tokenProvider.generateToken(user, Duration.ofDays(7));
		String accessToken = tokenProvider.generateToken(user, Duration.ofHours(2));
		refreshTokenRepository.save(RefreshToken.of(refreshToken, user.getId()));

		return LoginSucceedResponse.of(accessToken, refreshToken);
	}

	@Transactional
	public AccessTokenResponse reissue(RefreshTokenRequest request) {
		String refreshToken = request.refreshToken();
		RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken)
			.orElseThrow(TokenNotFoundException::new);

		User user = userService.getUserById(token.getUserId());
		String newAccessToken = tokenProvider.generateToken(user, Duration.ofHours(2));

		return AccessTokenResponse.of(newAccessToken);
	}
}
