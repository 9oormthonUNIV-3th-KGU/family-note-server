package goorm.kgu.familynote.domain.login.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.login.application.LoginService;
import goorm.kgu.familynote.domain.login.presentation.request.LoginRequest;
import goorm.kgu.familynote.domain.login.presentation.response.LoginSucceedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Login", description = "로그인 api / 담당자 : 이한음")
public class LoginController {
	private final LoginService loginService;

	@Operation(summary = "로그인", description = "로그인을 수행합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "로그인 성공",
			content = @Content(schema = @Schema(implementation = LoginSucceedResponse.class))
		),
		@ApiResponse(
			responseCode = "400",
			description = "비밀번호가 일치하지 않습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		),
		@ApiResponse(
			responseCode = "404",
			description = "유저를 찾을 수 없습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		)
	})
	@PostMapping("/login")
	public ResponseEntity<LoginSucceedResponse> login(
		@Valid @RequestBody LoginRequest request
	) {
		LoginSucceedResponse response = loginService.login(request);
		return ResponseEntity.ok(response);
	}
}
