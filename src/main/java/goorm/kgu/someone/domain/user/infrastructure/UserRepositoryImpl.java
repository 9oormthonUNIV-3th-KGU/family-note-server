package goorm.kgu.someone.domain.user.infrastructure;

import org.springframework.stereotype.Repository;

import goorm.kgu.someone.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
	private final JpaUserRepository jpaUserRepository;
}
