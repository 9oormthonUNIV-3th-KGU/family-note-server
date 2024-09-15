package goorm.kgu.familynote.domain.family.answer.presentation.response;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyAnswerPersistResponse(
        @Schema(description = "가족 응답 id", example = "1", requiredMode = REQUIRED)
        Long id
) {
    public static FamilyAnswerPersistResponse of(Long id) {
        return new FamilyAnswerPersistResponse(id);
    }
}
