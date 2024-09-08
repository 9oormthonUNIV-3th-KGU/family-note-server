package goorm.kgu.familynote.domain.family.member.presentation;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyPersistResponse;
import goorm.kgu.familynote.domain.family.member.application.FamilyMemberService;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import goorm.kgu.familynote.domain.family.member.presentation.request.FamilyMemberCreateRequest;
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
@RequestMapping("/api/v1/family/members")
@Tag(name = "Family Members", description = "가족 구성원 관련 api / 담당자 : 이한음")
public class FamilyMemberController {
	private final FamilyMemberService familyMemberService;

	@Operation(summary = "가족 구성원 모집", description = "가족 구성원을 모집하여 가족 그룹을 생성합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = "가족 구성원 모집 성공",
			content = @Content(schema = @Schema(implementation = FamilyPersistResponse.class))
		),
		@ApiResponse(
			responseCode = "404",
			description = "유저를 찾을 수 없습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		)
	})
	@ResponseStatus(CREATED)
	@PostMapping
	public ResponseEntity<FamilyPersistResponse> createFamilyMember(
		@Valid @RequestBody FamilyMemberCreateRequest request
	) {
		FamilyPersistResponse response = familyMemberService.saveFamilyMember(request);
		return ResponseEntity.ok(response);
	}

}
