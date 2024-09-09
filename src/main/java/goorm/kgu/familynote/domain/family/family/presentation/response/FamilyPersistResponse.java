package goorm.kgu.familynote.domain.family.family.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;

public record FamilyPersistResponse(
	@Schema(description = "가족 그룹 id", example = "1", requiredMode = REQUIRED)
	Long familyId
) {
	public static FamilyPersistResponse of(Long familyId) {
		return new FamilyPersistResponse(familyId);
	}
}
