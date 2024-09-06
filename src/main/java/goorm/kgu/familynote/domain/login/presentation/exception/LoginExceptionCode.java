package goorm.kgu.familynote.domain.login.presentation.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginExceptionCode implements ExceptionCode {

	INVALID_PASSWORD(BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}

