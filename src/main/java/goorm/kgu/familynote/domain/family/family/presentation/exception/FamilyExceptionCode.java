package goorm.kgu.familynote.domain.family.family.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FamilyExceptionCode implements ExceptionCode {
	FAMILY_NOT_FOUND(NOT_FOUND, "가족 그룹이 존재하지 않습니다."),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
