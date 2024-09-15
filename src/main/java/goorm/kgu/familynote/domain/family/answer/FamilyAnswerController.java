package goorm.kgu.familynote.domain.family.answer;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.family.answer.application.FamilyAnswerService;
import goorm.kgu.familynote.domain.family.answer.presentation.request.FamilyAnswerCreateRequest;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerListResponse;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerPersistResponse;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionResponse;
import goorm.kgu.familynote.domain.user.presentation.request.UserCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/family/answer")
@Tag(name = "Family Answer", description = "가족 답변 관련 api / 담당자 : 전민주")
public class FamilyAnswerController {
    private final FamilyAnswerService familyAnswerService;

    @Operation(summary = "가족 답변 생성", description = "가족 답변을 등록합니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "가족 답변 생성 성공",
                    content = @Content(schema = @Schema(implementation = FamilyAnswerPersistResponse.class))
            )
    })
    @ResponseStatus(CREATED)
    @PostMapping("/{familyQuestionId}")
    public ResponseEntity<FamilyAnswerPersistResponse> createFamilyAnswer(
            @PathVariable @NotNull @Positive @Parameter(description = "가족 질문 ID") Long familyQuestionId,
            @Valid @RequestBody FamilyAnswerCreateRequest request) {
        FamilyAnswerPersistResponse response = familyAnswerService.createFamilyAnswer(familyQuestionId, request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "가족 답변 조회", description = "하나의 가족 질문에 대한 가족 답변을 조회합니다. 내 답변 여부는 isAnswered 필드로 반환합니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "가족 답변 조회 성공",
                    content = @Content(schema = @Schema(implementation = FamilyAnswerListResponse.class))
            )
    })
    @GetMapping("/{familyQuestionId}")
    public ResponseEntity<FamilyAnswerListResponse> getFamilyAnswers(
            @PathVariable @NotNull @Positive @Parameter(description = "가족 질문 ID") Long familyQuestionId) {
        FamilyAnswerListResponse response = familyAnswerService.getFamilyAnswers(familyQuestionId);
        return ResponseEntity.ok(response);
    }

}
