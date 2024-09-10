package goorm.kgu.familynote.domain.question.baseQuestion.presentation.response;

import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.stream.Collectors;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record BaseQuestionResponse(
    @Schema(description = "기본 질문 id", example = "1", requiredMode = REQUIRED)
    Long baseQuestionId,

    @Schema(description = "기본 질문 내용", example = "짜장면 vs 짬뽕", requiredMode = REQUIRED)
    String content
) {

    public static List<BaseQuestionResponse> of(List<BaseQuestion> baseQuestions) {
        return baseQuestions.stream()
                .map(BaseQuestionResponse::of)
                .collect(Collectors.toList());
    }

    public static BaseQuestionResponse of(BaseQuestion baseQuestion) {
        return new BaseQuestionResponse(
                baseQuestion.getId(),
                baseQuestion.getContent()
        );
    }
}
