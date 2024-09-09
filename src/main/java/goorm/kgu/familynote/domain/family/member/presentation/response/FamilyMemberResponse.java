package goorm.kgu.familynote.domain.family.member.presentation.response;

import java.util.List;
import java.util.stream.Collectors;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;

public record FamilyMemberResponse(
	Long familyMemberId,
	String nickName,
	String role
) {

	public static List<FamilyMemberResponse> of(List<FamilyMember> familyMembers) {
		return familyMembers.stream()
			.map(FamilyMemberResponse::of)
			.collect(Collectors.toList());
	}

	public static FamilyMemberResponse of(FamilyMember familyMember) {
		return new FamilyMemberResponse(
			familyMember.getId(),
			familyMember.getUser().getNickname(),
			familyMember.getRole()
		);
	}
}
