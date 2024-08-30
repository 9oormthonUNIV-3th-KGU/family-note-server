package goorm.kgu.someone.domain.user.presentation.request;

public record UserRequest(
	String name,
	String email,
	String password
) {
}
