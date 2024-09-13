package goorm.kgu.familynote.domain.family.familyQuestion.presentation.response;

import goorm.kgu.familynote.common.response.PageableResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyQuestionPageResponse<T>(
        @Schema(
                description = "가족 질문 리스트",
                requiredMode = REQUIRED
        )
        List<FamilyQuestionResponse> contents,

        @Schema(
                description = "페이징 정보",
                requiredMode = REQUIRED
        )
        PageableResponse<T> pageable
) {

    public static FamilyQuestionPageResponse of(List<FamilyQuestionResponse> contents, PageableResponse pageable) {
        return new FamilyQuestionPageResponse(
                contents,
                pageable
        );
    }

}
