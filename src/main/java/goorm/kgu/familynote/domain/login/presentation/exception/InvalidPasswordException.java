package goorm.kgu.familynote.domain.login.presentation.exception;

import static goorm.kgu.familynote.domain.login.presentation.exception.LoginExceptionCode.INVALID_PASSWORD;

import goorm.kgu.familynote.common.exception.CustomException;

public class InvalidPasswordException extends CustomException {
	public InvalidPasswordException() {
		super(INVALID_PASSWORD);
	}
}
