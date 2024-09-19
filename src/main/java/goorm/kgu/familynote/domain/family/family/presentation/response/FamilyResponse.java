package goorm.kgu.familynote.domain.family.family.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.member.presentation.response.FamilyMemberResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record FamilyResponse(
	@Schema(description = "가족 그룹 ID", example = "1", requiredMode = REQUIRED)
	Long familyId,

	@Schema(description = "가족 그룹 이름", example = "행복한 우리집", requiredMode = REQUIRED)
	String familyName,

	@Schema(description = "내 이름", example = "이한음", requiredMode = REQUIRED)
	String myName,

	@Schema(
		description = "가족 구성원 목록",
		example = "[{\"familyMemberId\": 1, \"nickName\": \"이한음\"}, {\"familyMemberId\": 2, \"nickName\": \"전민주\"}]",
		requiredMode = REQUIRED
	)
	List<FamilyMemberResponse> familyMembers
) {

	public static FamilyResponse of(Family family, String myName) {
		return FamilyResponse.builder()
			.familyId(family.getId())
			.familyName(family.getFamilyName())
			.myName(myName)
			.familyMembers(FamilyMemberResponse.of(family.getFamilyMembers()))
			.build();
	}
}
