package goorm.kgu.familynote.domain.family.family.presentation.response;

import java.util.List;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.member.presentation.response.FamilyMemberResponse;
import lombok.Builder;

@Builder
public record FamilyResponse(
	Long familyId,
	String myName,
	List<FamilyMemberResponse> familyMembers
) {

	public static FamilyResponse of(Family family, String myName) {
		return FamilyResponse.builder()
			.familyId(family.getId())
			.myName(myName)
			.familyMembers(FamilyMemberResponse.of(family.getFamilyMembers()))
			.build();
	}
}
