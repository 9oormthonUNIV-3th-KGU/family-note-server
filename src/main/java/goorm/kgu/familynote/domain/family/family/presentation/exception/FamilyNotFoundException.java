package goorm.kgu.familynote.domain.family.family.presentation.exception;

import static goorm.kgu.familynote.domain.family.family.presentation.exception.FamilyExceptionCode.FAMILY_NOT_FOUND;

import goorm.kgu.familynote.common.exception.CustomException;

public class FamilyNotFoundException extends CustomException {

	public FamilyNotFoundException() {
		super(FAMILY_NOT_FOUND);
	}
}
