package goorm.kgu.someone.domain.user.presentation.exception;

import static goorm.kgu.someone.domain.user.presentation.exception.UserExceptionCode.NOT_FOUND_USER;

import goorm.kgu.someone.common.exception.CustomException;

public class NotFoundUserException extends CustomException {
	public NotFoundUserException() {
		super(NOT_FOUND_USER);
	}
}
