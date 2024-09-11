package goorm.kgu.familynote.domain.question.familyQuestion.presentation.response;

import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import io.swagger.v3.oas.annotations.media.Schema;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyQuestionResponse(
        @Schema(description = "가족 질문 id", example = "1", requiredMode = REQUIRED)
        Long familyQuestionId,

        @Schema(description = "가족 질문 내용", example = "제일 좋아하는 과일은?", requiredMode = REQUIRED)
        String content
) {

        public static FamilyQuestionResponse of(FamilyQuestion familyQuestion) {
                return new FamilyQuestionResponse(
                        familyQuestion.getId(),
                        familyQuestion.getBaseQuestion().getContent()
                );
        }
}
