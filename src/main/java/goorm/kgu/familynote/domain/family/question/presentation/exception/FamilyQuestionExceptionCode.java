package goorm.kgu.familynote.domain.family.question.presentation.exception;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Getter
@AllArgsConstructor
public enum FamilyQuestionExceptionCode implements ExceptionCode {
    FAMILY_QUESTION_NOT_FOUND(NOT_FOUND, "가족 질문을 찾을 수 없습니다."),
    INSUFFICIENT_RESPONSES_FOR_NEW_QUESTION(UNPROCESSABLE_ENTITY, "이전 가족 질문에 모두 답하지 않아 새로운 질문을 생성할 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
