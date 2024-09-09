package goorm.kgu.familynote.domain.user.presentation.request;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateRequest(
	@Schema(description = "닉네임", example = "홍길동", requiredMode = REQUIRED)
	@NotNull
	String nickname,

	@Schema(description = "비밀번호", example = "password1234", requiredMode = REQUIRED)
	@NotNull @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", message = "비밀번호는 최소 8자리 이상, 영문자와 숫자를 포함해야 합니다.")
	String password

	// TODO : 닉네임 길이 제한 및 비밀번호 패턴에 대한 논의 필요
) {
}
