package goorm.kgu.familynote.domain.family.question;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.family.question.application.FamilyQuestionService;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionPageResponse;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionPersistResponse;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/family/question")
@Tag(name = "Family Question", description = "가족 질문 관련 api / 담당자 : 전민주")
public class FamilyQuestionController {
    private final FamilyQuestionService familyQuestionService;

    @Operation(summary = "가족 질문 생성", description = "가족 질문을 등록합니다. 이전에 등록된 가족 질문에 모든 가족 구정원이 답변을 해야 정상적으로 생성됩니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "가족 질문 생성 성공",
                    content = @Content(schema = @Schema(implementation = FamilyQuestionPersistResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "이전 가족 질문에 모두 답하지 않아 새로운 질문을 생성할 수 없습니다.",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "가족 구성원이 아닙니다.",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "모든 기본 질문에 답변하여서 새로운 가족 질문을 생성할 수 없습니다.",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "기본 질문이 0개 이하여서 가족 질문을 생성할 수 없습니다.",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @ResponseStatus(CREATED)
    @PostMapping("/{familyId}")
    public ResponseEntity<FamilyQuestionPersistResponse> createFamilyQuestion(
            @Parameter(description = "가족 ID", example = "1", required = true) @PathVariable("familyId") @Positive Long familyId) {
        FamilyQuestionPersistResponse response = familyQuestionService.createFamilyQuestion(familyId);
        return ResponseEntity.status(CREATED).body(response);
    }

    @Operation(summary = "가족 질문 조회", description = "가족 질문을 조회합니다. 생성된 시간 기준 최신순으로 정렬되어 반환합니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "가족 질문 조회 성공",
                    content = @Content(schema = @Schema(implementation = FamilyQuestionPageResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "가족 구성원이 아닙니다.",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
            )
    })
    @GetMapping("/{familyId}")
    public ResponseEntity<FamilyQuestionPageResponse> getFamilyQuestions(
            @Parameter(description = "가족 ID", example = "1", required = true) @PathVariable("familyId") @Positive Long familyId,

            @Parameter(description = "페이지 번호", example = "0", required = true)
            @RequestParam(defaultValue = "0")
            @PositiveOrZero int page,

            @Parameter(description = "페이지 크기", example = "5", required = true)
            @RequestParam(defaultValue = "5")
            @Positive int size
    ) {
        FamilyQuestionPageResponse response = familyQuestionService.getFamilyQuestions(familyId, page, size);
        return ResponseEntity.ok(response);
    }

}