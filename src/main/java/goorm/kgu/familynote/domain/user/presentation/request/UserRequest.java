package goorm.kgu.familynote.domain.user.presentation.request;

public record UserRequest(
	String name,
	String email,
	String password
) {
}
