package goorm.kgu.familynote.domain.user.presentation.exception;

import static goorm.kgu.familynote.domain.user.presentation.exception.UserExceptionCode.USER_NOT_FOUND;

import goorm.kgu.familynote.common.exception.CustomException;

public class UserNotFoundException extends CustomException {
	public UserNotFoundException() {
		super(USER_NOT_FOUND);
	}
}
