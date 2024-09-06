package goorm.kgu.familynote.domain.login.presentation.request;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LoginRequest(
	@Schema(description = "닉네임", example = "umm_programer", requiredMode = REQUIRED)
	@NotNull
	String nickname,

	@Schema(description = "비밀번호", example = "password1234", requiredMode = REQUIRED)
	@NotNull
	String password
) {
}
