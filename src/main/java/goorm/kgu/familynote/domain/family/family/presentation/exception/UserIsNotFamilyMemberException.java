package goorm.kgu.familynote.domain.family.family.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;
import static goorm.kgu.familynote.domain.family.family.presentation.exception.FamilyExceptionCode.USER_IS_NOT_FAMILY_MEMBER;

public class UserIsNotFamilyMemberException extends CustomException {
    public UserIsNotFamilyMemberException() {
        super(USER_IS_NOT_FAMILY_MEMBER);
    }
}