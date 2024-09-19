package goorm.kgu.familynote.domain.user.presentation.exception;

import static goorm.kgu.familynote.domain.user.presentation.exception.UserExceptionCode.USER_NICKNAME_DUPLICATED;

import goorm.kgu.familynote.common.exception.CustomException;

public class UserNicknameDuplicatedException extends CustomException {
	public UserNicknameDuplicatedException() {
		super(USER_NICKNAME_DUPLICATED);
	}
}
