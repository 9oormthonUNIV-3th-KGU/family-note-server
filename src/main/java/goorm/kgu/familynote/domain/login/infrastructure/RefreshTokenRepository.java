package goorm.kgu.familynote.domain.login.infrastructure;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import goorm.kgu.familynote.domain.login.domain.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
