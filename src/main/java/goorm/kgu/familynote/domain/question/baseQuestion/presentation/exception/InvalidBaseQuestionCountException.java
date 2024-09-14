package goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;

import static goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.BaseQuestionExceptionCode.INVALID_BASE_QUESTION_COUNT;

public class InvalidBaseQuestionCountException extends CustomException {

    public InvalidBaseQuestionCountException() {
        super(INVALID_BASE_QUESTION_COUNT);
    }
}

