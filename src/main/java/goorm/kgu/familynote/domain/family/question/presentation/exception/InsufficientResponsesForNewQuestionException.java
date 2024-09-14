package goorm.kgu.familynote.domain.family.question.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;

import static goorm.kgu.familynote.domain.family.question.presentation.exception.FamilyQuestionExceptionCode.INSUFFICIENT_RESPONSES_FOR_NEW_QUESTION;

public class InsufficientResponsesForNewQuestionException extends CustomException {
    public InsufficientResponsesForNewQuestionException() {
        super(INSUFFICIENT_RESPONSES_FOR_NEW_QUESTION);
    }
}