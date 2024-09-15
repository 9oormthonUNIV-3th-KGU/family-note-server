package goorm.kgu.familynote.domain.family.question.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyQuestionPersistResponse(
        @Schema(description = "가족 질문 id", example = "1", requiredMode = REQUIRED)
        Long familyQuestionId
) {
    public static FamilyQuestionPersistResponse of(Long familyQuestionId) {
        return new FamilyQuestionPersistResponse(familyQuestionId);
    }
}
