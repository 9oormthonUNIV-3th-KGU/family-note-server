package goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum BaseQuestionExceptionCode implements ExceptionCode {
    BASE_QUESTION_NOT_FOUND(NOT_FOUND, "해당 기본 질문을 찾을 수 없습니다."),
    INVALID_BASE_QUESTION_COUNT(NOT_FOUND, "기본 질문이 0개 이하입니다."),
    NO_MORE_BASE_QUESTION_EXCEPTION(NOT_FOUND, "더 이상 제공할 기본 질문이 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
