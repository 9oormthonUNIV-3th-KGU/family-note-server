package goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;

import static goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.BaseQuestionExceptionCode.NO_MORE_BASE_QUESTION_EXCEPTION;

public class NoMoreBaseQuestionException extends CustomException {

    public NoMoreBaseQuestionException() {
        super(NO_MORE_BASE_QUESTION_EXCEPTION);
    }
}