package goorm.kgu.familynote.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import goorm.kgu.familynote.domain.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(

	@Schema(description = "유저 ID", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "닉네임", example = "박주현", requiredMode = REQUIRED)
	String nickname
) {
	public static UserResponse from(User user) {
		return UserResponse.builder()
			.id(user.getId())
			.nickname(user.getNickname())
			.build();
	}
}
