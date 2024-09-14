package goorm.kgu.familynote.domain.family.answer.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyAnswerResponse(
        @Schema(description = "답변자 닉네임", example = "홍길동", requiredMode = REQUIRED)
        String nickname,

        @Schema(description = "가족 응답 내용", example = "고양이를 더 좋아해요. 더 귀엽거든요.", requiredMode = REQUIRED)
        String content
) {
    public static FamilyAnswerResponse of(String nickname, String content) {
        return new FamilyAnswerResponse(nickname, content);
    }
}
