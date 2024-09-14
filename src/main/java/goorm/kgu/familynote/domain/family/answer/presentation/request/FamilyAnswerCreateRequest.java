package goorm.kgu.familynote.domain.family.answer.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyAnswerCreateRequest(
        @Schema(description = "가족 질문 Id", example = "1", requiredMode = REQUIRED)
        Long familyQuestionId,

        @Schema(description = "가족 답변 내용", example = "고양이를 더 좋아함.", requiredMode = REQUIRED)
        @Pattern(regexp = ".{1,1000}", message = "가족 답변은 최소 1자 이상, 최대 1000자 이하여야 합니다.")
        String content
) {
}
