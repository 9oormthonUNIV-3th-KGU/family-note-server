package goorm.kgu.familynote.domain.user.presentation.exception;

import static goorm.kgu.familynote.domain.user.presentation.exception.UserExceptionCode.USER_NOT_AUTHENTICATED;

import goorm.kgu.familynote.common.exception.CustomException;

public class UserNotAuthenticatedException extends CustomException {

	public UserNotAuthenticatedException() {
		super(USER_NOT_AUTHENTICATED);
	}
}
