package goorm.kgu.familynote.common.auth.application;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
	private final UserService userService;

	@Override
	public User loadUserByUsername(String nickname) {
		return userService.getUserByNickname(nickname);
	}
}
