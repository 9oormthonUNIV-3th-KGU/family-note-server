package goorm.kgu.someone.domain.user.presentation.response;

public record UserResponse(
	Long id,
	String name,
	String email
) {
}
