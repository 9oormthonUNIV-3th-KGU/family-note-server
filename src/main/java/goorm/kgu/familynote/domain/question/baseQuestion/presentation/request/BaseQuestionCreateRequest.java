package goorm.kgu.familynote.domain.question.baseQuestion.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record BaseQuestionCreateRequest(
        @Schema(description = "기본 질문 내용", example = "탕수육 먹을 때 부먹 vs 찍먹", requiredMode = REQUIRED)
        String content
) {
}
