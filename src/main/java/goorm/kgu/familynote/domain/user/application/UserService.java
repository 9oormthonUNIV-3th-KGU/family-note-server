package goorm.kgu.familynote.domain.user.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.user.domain.User;
import goorm.kgu.familynote.domain.user.domain.UserRepository;
import goorm.kgu.familynote.domain.user.presentation.exception.NotFoundUserException;
import goorm.kgu.familynote.domain.user.presentation.request.UserCreateRequest;
import goorm.kgu.familynote.domain.user.presentation.response.UserPersistResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public UserPersistResponse createUser(UserCreateRequest request) {
		User user = User.create(
			request.nickname(),
			bCryptPasswordEncoder.encode(request.password())
		);
		Long id = userRepository.save(user).getId();
		return UserPersistResponse.of(id);
	}

	public void updateRefreshToken(String nickname, String refreshToken) {
		User user = getUserByNickname(nickname);
		user.updateRefreshToken(refreshToken);
	}

	public User getUserByNickname(String nickname) {
		return userRepository.findByNickname(nickname)
			.orElseThrow(NotFoundUserException::new);
	}
}
