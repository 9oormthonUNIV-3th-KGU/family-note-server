package goorm.kgu.familynote.domain.family.answer.presentation.response;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FamilyAnswerListResponse(
        @Schema(description = "답변 여부", example = "true", requiredMode = REQUIRED)
        Boolean isAnswered,

        @Schema(description = "가족 답변 리스트", example =
                "[\n{\n\"nickname\": \"홍길동\",\n" +
                "      \"content\": \"짬뽕이 더 맛있지. 얼큰하니\"\n},\n" +
                "    {\n\"nickname\": \"홍길순\",\n" +
                "       \"content\": \"짭쪼름한 짜장이 더 맛있지. 아삭한 양파까지\"\n}\n]"
                , requiredMode = REQUIRED)
        List<FamilyAnswerResponse> contents
) {
    public static FamilyAnswerListResponse of(Boolean isAnswered, List<FamilyAnswer> contents) {
        List<FamilyAnswerResponse> responseContents = contents.stream()
                .map(familyAnswer ->
                        new FamilyAnswerResponse(familyAnswer.getUser().getNickname(), familyAnswer.getContent()))
                .toList();
        return new FamilyAnswerListResponse(isAnswered, responseContents);
    }

}
