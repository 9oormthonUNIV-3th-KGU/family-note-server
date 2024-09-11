package goorm.kgu.familynote.domain.question.baseQuestion.presentation;

import goorm.kgu.familynote.common.exception.ExceptionResponse;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyPersistResponse;
import goorm.kgu.familynote.domain.family.member.presentation.request.FamilyMemberCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.application.BaseQuestionService;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.request.BaseQuestionCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponse;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponseList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question/base")
@Tag(name = "Base Question", description = "기본 질문 관련 api / 담당자 : 전민주")
public class BaseQuestionController {
    private final BaseQuestionService baseQuestionService;

    @Operation(summary = "기본 질문 등록", description = "기본 질문을 등록합니다. 개발자/관리자가 API를 통해서 조작할 수 있습니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "기본 질문 등록 성공",
                    content = @Content(schema = @Schema(implementation = BaseQuestionResponseList.class))
            )
    })
    @ResponseStatus(CREATED)
    @PostMapping
    public ResponseEntity<BaseQuestionResponseList> createBaseQuestions(
            @Valid @RequestBody List<BaseQuestionCreateRequest> requests
    ) {
        BaseQuestionResponseList response = baseQuestionService.saveBaseQuestions(requests);
        return ResponseEntity.ok(response);
    }

}
