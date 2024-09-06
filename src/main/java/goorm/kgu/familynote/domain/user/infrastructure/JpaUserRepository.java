package goorm.kgu.familynote.domain.user.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.user.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Long>{
	Optional<User> findByNickname(String nickname);
}
