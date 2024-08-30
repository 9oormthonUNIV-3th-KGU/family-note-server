package goorm.kgu.someone.domain.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.someone.domain.user.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Long>{
}
