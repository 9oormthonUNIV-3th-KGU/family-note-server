package goorm.kgu.familynote.domain.login.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 7)
public class RefreshToken {

	@Id
	private String refreshToken;
	private Long userId;

	public RefreshToken(String refreshToken, Long userId) {
		this.refreshToken = refreshToken;
		this.userId = userId;
	}

	public static RefreshToken of(String refreshToken, Long userId) {
		return RefreshToken.builder()
			.refreshToken(refreshToken)
			.userId(userId)
			.build();
	}

}
