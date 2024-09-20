package goorm.kgu.familynote.domain.family.member.presentation.exception;

import goorm.kgu.familynote.common.exception.CustomException;
import static goorm.kgu.familynote.domain.family.member.presentation.exception.FamilyMemberExceptionCode.USER_IS_NOT_FAMILY_MEMBER;

public class UserIsNotFamilyMemberException extends CustomException {
    public UserIsNotFamilyMemberException() {
        super(USER_IS_NOT_FAMILY_MEMBER);
    }
}