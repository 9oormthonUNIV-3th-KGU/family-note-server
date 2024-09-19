package goorm.kgu.familynote.domain.family.member.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;
import java.util.stream.Collectors;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import io.swagger.v3.oas.annotations.media.Schema;

public record FamilyMemberResponse(
	@Schema(description = "가족 구성원 ID", example = "1", requiredMode = REQUIRED)
	Long familyMemberId,

	@Schema(description = "닉네임", example = "이한음", requiredMode = REQUIRED)
	String nickName
) {

	public static List<FamilyMemberResponse> of(List<FamilyMember> familyMembers) {
		return familyMembers.stream()
			.map(FamilyMemberResponse::of)
			.collect(Collectors.toList());
	}

	public static FamilyMemberResponse of(FamilyMember familyMember) {
		return new FamilyMemberResponse(
			familyMember.getId(),
			familyMember.getUser().getNickname()
		);
	}
}
