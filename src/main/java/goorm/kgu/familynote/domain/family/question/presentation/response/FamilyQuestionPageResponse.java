package goorm.kgu.familynote.domain.family.question.presentation.response;

import goorm.kgu.familynote.common.response.PageableResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyQuestionPageResponse<T>(
        @Schema(description = "가족 질문 리스트",
                example = "[\n{\n\"familyQuestionId\": 196,\n" +
                        " \"content\": \"오늘 친구들과 있었던 재미있는 일이나 고민이 있었나요?\",\n" +
                        " \"createdAt\": \"2024-09-13T21:48:52.450273\"\n},\n" +
                        " {\n\"familyQuestionId\": 195,\n" +
                        "  \"content\": \"최근에 읽은 책이나 본 영상 중 추천하고 싶은 것이 있나요?\",\n" +
                        "  \"createdAt\": \"2024-09-13T21:48:34.456825\"\n}\n]",
                requiredMode = REQUIRED)
        List<FamilyQuestionResponse> contents,

        @Schema(description = "페이징 정보", requiredMode = REQUIRED)
        PageableResponse<T> pageable
) {

    public static FamilyQuestionPageResponse of(List<FamilyQuestionResponse> contents, PageableResponse pageable) {
        return new FamilyQuestionPageResponse(
                contents,
                pageable
        );
    }

}
