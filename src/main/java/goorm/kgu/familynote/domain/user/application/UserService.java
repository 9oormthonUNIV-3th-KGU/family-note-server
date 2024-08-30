package goorm.kgu.familynote.domain.user.application;

import org.springframework.stereotype.Service;

import goorm.kgu.familynote.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
}
