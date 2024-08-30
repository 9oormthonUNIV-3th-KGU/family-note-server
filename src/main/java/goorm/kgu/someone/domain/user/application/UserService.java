package goorm.kgu.someone.domain.user.application;

import org.springframework.stereotype.Service;

import goorm.kgu.someone.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
}
