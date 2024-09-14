package goorm.kgu.familynote.domain.question.baseQuestion.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record BaseQuestionPersistListResponse(
        @Schema(description = "기본 질문 id 리스트", example = "[1, 2, 3]", requiredMode = REQUIRED)
        List<Long> baseQuestionIdList
) {
    public static BaseQuestionPersistListResponse of(List<Long> baseQuestionIdList) {
        return new BaseQuestionPersistListResponse(baseQuestionIdList);
    }
}
