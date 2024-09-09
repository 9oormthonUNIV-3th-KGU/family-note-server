package goorm.kgu.familynote.domain.family.member.presentation.exception;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FamilyMemberExceptionCode implements ExceptionCode {

	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
