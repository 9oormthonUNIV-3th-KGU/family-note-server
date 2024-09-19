package goorm.kgu.familynote.domain.family.family.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.family.family.application.FamilyService;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyListResponse;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/family")
@Tag(name = "Family", description = "가족 그룹 관련 api / 담당자 : 이한음")
public class FamilyController {
	private final FamilyService familyService;

	@Operation(summary = "가족 구성원 정보 조회", description = "가족 구성원 정보를 조회합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "가족 구성원 정보 조회 성공",
			content = @Content(schema = @Schema(implementation = FamilyResponse.class))
		),
		@ApiResponse(
			responseCode = "403",
			description = "사용자 인증에 실패하였습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		),
		@ApiResponse(
			responseCode = "404",
			description = "가족 그룹이 존재하지 않습니다./ 사용자를 찾을 수 없습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		)
	})
	@GetMapping("/{familyId}")
	public ResponseEntity<FamilyResponse> getFamily(
		@Parameter(description = "가족 ID", example = "1", required = true) @PathVariable("familyId") @Positive Long familyId
	) {
		FamilyResponse response = familyService.getFamily(familyId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "가족 그룹 목록 조회", description = "내가 속한 가족 그룹 목록을 조회합니다.")
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "가족 그룹 목록 조회 성공",
			content = @Content(schema = @Schema(implementation = FamilyListResponse.class))
		),
		@ApiResponse(
			responseCode = "403",
			description = "사용자 인증에 실패하였습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		),
		@ApiResponse(
			responseCode = "404",
			description = "가족 그룹이 존재하지 않습니다./ 사용자를 찾을 수 없습니다.",
			content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
		)
	})
	@GetMapping("/list")
	public ResponseEntity<FamilyListResponse> getFamilyList() {
		FamilyListResponse response = familyService.getMyFamilyList();
		return ResponseEntity.ok(response);
	}
}
