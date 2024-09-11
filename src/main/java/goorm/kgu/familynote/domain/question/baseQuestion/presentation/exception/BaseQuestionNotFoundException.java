package goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;

import static goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.BaseQuestionExceptionCode.BASE_QUESTION_NOT_FOUND;

public class BaseQuestionNotFoundException extends CustomException {

    public BaseQuestionNotFoundException() {
        super(BASE_QUESTION_NOT_FOUND);
    }
}
