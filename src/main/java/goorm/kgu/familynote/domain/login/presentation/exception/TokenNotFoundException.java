package goorm.kgu.familynote.domain.login.presentation.exception;

import static goorm.kgu.familynote.domain.login.presentation.exception.LoginExceptionCode.TOKEN_NOT_FOUND;

import goorm.kgu.familynote.common.exception.CustomException;

public class TokenNotFoundException extends CustomException {
	public TokenNotFoundException() {
		super(TOKEN_NOT_FOUND);
	}
}
