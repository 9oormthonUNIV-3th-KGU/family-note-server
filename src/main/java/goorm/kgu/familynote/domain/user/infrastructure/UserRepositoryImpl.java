package goorm.kgu.familynote.domain.user.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import goorm.kgu.familynote.domain.user.domain.User;
import goorm.kgu.familynote.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
	private final JpaUserRepository jpaUserRepository;

	@Override
	public User save(User user) {
		return jpaUserRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		return jpaUserRepository.findById(id);
	}

	@Override
	public Optional<User> findByNickname(String nickname) {
		return jpaUserRepository.findByNickname(nickname);
	}

	@Override
	public List<User> findByNicknameContaining(String nickname) {
		return jpaUserRepository.findByNicknameContaining(nickname);
	}
}
