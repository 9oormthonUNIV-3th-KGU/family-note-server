package goorm.kgu.familynote.domain.user.presentation;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.presentation.request.UserCreateRequest;
import goorm.kgu.familynote.domain.user.presentation.response.UserListResponse;
import goorm.kgu.familynote.domain.user.presentation.response.UserPersistResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

	@Operation(summary = "유저 생성", description = "유저를 생성합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = "유저 생성 성공",
			content = @Content(schema = @Schema(implementation = UserPersistResponse.class))
		)
	})
	@ResponseStatus(CREATED)
	@PostMapping("/signup")
	public ResponseEntity<UserPersistResponse> createUser(
		@Valid @RequestBody UserCreateRequest request
	) {
		UserPersistResponse response = userService.createUser(request);
		return ResponseEntity.status(CREATED).body(response);
	}

	@Operation(summary = "유저 검색", description = "닉네임 기반으로 유저를 검색합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "유저 검색 성공",
			content = @Content(schema = @Schema(implementation = UserListResponse.class))
		)
	})
	@GetMapping
	public ResponseEntity<UserListResponse> searchUserByNickname(
		@Parameter(description = "닉네임", example = "길동", required = true) @RequestParam String nickname
	) {
		UserListResponse response = userService.getUsersByNickname(nickname);
		return ResponseEntity.ok(response);
	}

}
