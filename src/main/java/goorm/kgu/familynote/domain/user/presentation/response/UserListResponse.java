package goorm.kgu.familynote.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;
import java.util.stream.Collectors;

import goorm.kgu.familynote.domain.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserListResponse(
	@Schema(
		description = "유저 리스트",
		example = "[{\"id\": 1, \"nickname\": \"전민주\"}, {\"id\": 2, \"nickname\": \"이한음\"}]",
		requiredMode = REQUIRED
	)
	List<UserResponse> contents
) {
	public static UserListResponse from(List<User> users) {
		return new UserListResponse(
			users.stream()
				.map(UserResponse::from)
				.collect(Collectors.toList())
		);
	}
}
