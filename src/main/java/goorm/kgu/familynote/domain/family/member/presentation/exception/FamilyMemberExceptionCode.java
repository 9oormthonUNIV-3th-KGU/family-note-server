package goorm.kgu.familynote.domain.family.member.presentation.exception;

import org.springframework.http.HttpStatus;

import goorm.kgu.familynote.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Getter
@AllArgsConstructor
public enum FamilyMemberExceptionCode implements ExceptionCode {
	USER_IS_NOT_FAMILY_MEMBER(FORBIDDEN, "가족 구성원이 아닙니다.")
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
