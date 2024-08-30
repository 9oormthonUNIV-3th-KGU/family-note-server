package goorm.kgu.familynote.domain.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.user.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Long>{
}
