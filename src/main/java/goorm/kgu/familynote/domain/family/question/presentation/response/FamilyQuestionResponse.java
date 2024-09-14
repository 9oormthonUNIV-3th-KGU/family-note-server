package goorm.kgu.familynote.domain.family.question.presentation.response;

import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyQuestionResponse(
        @Schema(description = "가족 질문 id", example = "1", requiredMode = REQUIRED)
        Long familyQuestionId,

        @Schema(description = "가족 질문 내용", example = "제일 좋아하는 과일은?", requiredMode = REQUIRED)
        String content,

        @Schema(description = "생성날짜", example = "2024-09-11T20:37:18.396596", requiredMode = REQUIRED)
        LocalDateTime createdAt
) {

        public static FamilyQuestionResponse of(FamilyQuestion familyQuestion) {
                return new FamilyQuestionResponse(
                        familyQuestion.getId(),
                        familyQuestion.getBaseQuestion().getContent(),
                        familyQuestion.getCreatedAt()
                );
        }
}
