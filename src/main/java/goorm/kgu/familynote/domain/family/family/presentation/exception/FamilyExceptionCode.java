package goorm.kgu.familynote.domain.family.family.presentation.exception;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FamilyExceptionCode implements ExceptionCode {
	USER_IS_NOT_FAMILY_MEMBER(FORBIDDEN, "가족 구성원이 아닙니다."),
	FAMILY_NOT_FOUND(NOT_FOUND, "가족 그룹이 존재하지 않습니다.")
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
