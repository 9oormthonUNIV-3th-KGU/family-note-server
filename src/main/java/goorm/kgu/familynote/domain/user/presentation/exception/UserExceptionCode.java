package goorm.kgu.familynote.domain.user.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionCode implements ExceptionCode {
	NOT_FOUND_USER(NOT_FOUND, "사용자를 찾을 수 없습니다"),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
