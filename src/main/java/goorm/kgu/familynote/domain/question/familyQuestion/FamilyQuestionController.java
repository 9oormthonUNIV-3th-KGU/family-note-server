package goorm.kgu.familynote.domain.question.familyQuestion;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyPersistResponse;
import goorm.kgu.familynote.domain.question.baseQuestion.application.BaseQuestionService;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.request.BaseQuestionCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponseList;
import goorm.kgu.familynote.domain.question.familyQuestion.application.FamilyQuestionService;
import goorm.kgu.familynote.domain.question.familyQuestion.presentation.response.FamilyQuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question/family")
@Tag(name = "Family Question", description = "가족 질문 관련 api / 담당자 : 전민주")
public class FamilyQuestionController {
    private final FamilyQuestionService familyQuestionService;

    @Operation(summary = "가족 질문 생성", description = "가족 질문을 등록합니다. 이전에 등록된 가족 질문에 모든 가족 구정원이 답변을 해야 정상적으로 생성됩니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "가족 질문 생성 성공",
                    content = @Content(schema = @Schema(implementation = FamilyQuestionResponse.class))
            )
    })
    @ResponseStatus(CREATED)
    @PostMapping
    public ResponseEntity<FamilyQuestionResponse> createFamilyQuestion() {
        FamilyQuestionResponse response = familyQuestionService.createFamilyQuestion();
        return ResponseEntity.ok(response);
    }

}