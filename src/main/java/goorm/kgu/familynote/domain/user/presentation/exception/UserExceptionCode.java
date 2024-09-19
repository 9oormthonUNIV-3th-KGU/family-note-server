package goorm.kgu.familynote.domain.user.presentation.exception;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionCode implements ExceptionCode {
	USER_NOT_AUTHENTICATED(FORBIDDEN, "사용자 인증에 실패하였습니다."),
	USER_NOT_FOUND(NOT_FOUND, "사용자를 찾을 수 없습니다."),
	USER_NICKNAME_DUPLICATED(CONFLICT, "중복된 닉네임 입니다."),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
