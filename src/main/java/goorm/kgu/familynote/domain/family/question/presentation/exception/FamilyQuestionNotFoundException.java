package goorm.kgu.familynote.domain.family.question.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;

import static goorm.kgu.familynote.domain.family.question.presentation.exception.FamilyQuestionExceptionCode.FAMILY_QUESTION_NOT_FOUND;

public class FamilyQuestionNotFoundException extends CustomException {
    public FamilyQuestionNotFoundException() {
        super(FAMILY_QUESTION_NOT_FOUND);
    }
}