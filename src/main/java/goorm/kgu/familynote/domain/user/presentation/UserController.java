package goorm.kgu.familynote.domain.user.presentation;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.presentation.request.UserCreateRequest;
import goorm.kgu.familynote.domain.user.presentation.response.UserPersistResponse;
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
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "유저 관련 api / 담당자 : 이한음")
public class UserController {
	private final UserService userService;

	@Operation(summary = "회원 생성", description = "회원을 생성합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = "회원 생성 성공",
			content = @Content(schema = @Schema(implementation = UserPersistResponse.class))
		)
	})
	@ResponseStatus(CREATED)
	@PostMapping
	public ResponseEntity<UserPersistResponse> createUser(
		@Valid @RequestBody UserCreateRequest request
	) {
		UserPersistResponse response = userService.createUser(request);
		return ResponseEntity.ok(response);
	}


}
