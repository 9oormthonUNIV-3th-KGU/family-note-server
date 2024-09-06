package goorm.kgu.familynote.domain.user.domain;

import java.util.Optional;

public interface UserRepository {
	User save(User user);

	Optional<User> findByNickname(String nickname);
}
