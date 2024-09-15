package goorm.kgu.familynote.domain.family.answer.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyAnswerCreateRequest(
        @Schema(description = "가족 답변 내용", example = "고양이를 더 좋아함.", requiredMode = REQUIRED)
        @Size(min = 1, max = 1000)
        String content
) {
}
