package goorm.kgu.familynote.domain.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	User save(User user);

	Optional<User> findById(Long id);

	Optional<User> findByNickname(String nickname);

	boolean existsByNickname(String nickname);

	List<User> findByNicknameContaining(String nickname);
}
