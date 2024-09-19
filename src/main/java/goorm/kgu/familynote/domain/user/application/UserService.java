package goorm.kgu.familynote.domain.user.application;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.user.domain.User;
import goorm.kgu.familynote.domain.user.domain.UserRepository;
import goorm.kgu.familynote.domain.user.presentation.exception.UserNicknameDuplicatedException;
import goorm.kgu.familynote.domain.user.presentation.exception.UserNotAuthenticatedException;
import goorm.kgu.familynote.domain.user.presentation.exception.UserNotFoundException;
import goorm.kgu.familynote.domain.user.presentation.request.UserCreateRequest;
import goorm.kgu.familynote.domain.user.presentation.response.UserListResponse;
import goorm.kgu.familynote.domain.user.presentation.response.UserPersistResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public UserPersistResponse createUser(UserCreateRequest request) {
		validateNicknameDuplication(request.nickname());
		User user = User.create(
			request.nickname(),
			bCryptPasswordEncoder.encode(request.password())
		);
		Long id = userRepository.save(user).getId();
		return UserPersistResponse.of(id);
	}

	public User me() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			return getUserByNickname(username);
		} catch (Exception e) {
			throw new UserNotAuthenticatedException();
		}
	}

	public User getUserById(String id) {
		return userRepository.findById(Long.parseLong(id))
			.orElseThrow(UserNotFoundException::new);
	}

	public UserListResponse getUsersByNickname(String nickname) {
		List<User> users = userRepository.findByNicknameContaining(nickname);
		return UserListResponse.from(users);
	}

	public void updateRefreshToken(String nickname, String refreshToken) {
		User user = getUserByNickname(nickname);
		user.updateRefreshToken(refreshToken);
	}

	public User getUserByNickname(String nickname) {
		return userRepository.findByNickname(nickname)
			.orElseThrow(UserNotFoundException::new);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(UserNotFoundException::new);
	}

	private void validateNicknameDuplication(String nickname) {
		if (userRepository.existsByNickname(nickname)) {
			throw new UserNicknameDuplicatedException();
		}
	}
}
