package goorm.kgu.familynote.domain.question.baseQuestion.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record BaseQuestionResponseList (
    @Schema(
        description = "기본 질문 리스트",
        example =
        "    [{\"content\": \"오늘 하루 중 가장 즐거웠던 일은 무엇이었나요?\"},\n" +
        "    {\"content\": \"요즘 가장 관심 있는 취미나 활동은 무엇인가요?\"},\n" +
        "    {\"content\": \"어렸을 때의 꿈은 무엇이었나요? 지금도 그 꿈이 있나요?\"}]",
        requiredMode = REQUIRED
    )
    List<BaseQuestionResponse> contents
) {

    public static BaseQuestionResponseList of(List<BaseQuestionResponse> baseQuestionResponseList) {
        return new BaseQuestionResponseList(
                baseQuestionResponseList
        );
    }
}
