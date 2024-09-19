package goorm.kgu.familynote.domain.family.family.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;
import java.util.stream.Collectors;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record FamilyListResponse(
	@Schema(
		description = "가족 그룹 목록",
		example = "[{\"familyId\": 1, \"familyName\": \"행복한 우리집\", \"myName\": \"이한음\", \"familyMembers\": [{\"familyMemberId\": 1, \"nickName\": \"이한음\"}, {\"familyMemberId\": 2, \"nickName\": \"전민주\"}]}]",
		requiredMode = REQUIRED
	)
	List<FamilyResponse> contents
) {
	public static FamilyListResponse of(List<Family> familyList, String myName) {
		return FamilyListResponse.builder()
			.contents(familyList.stream()
				.map(family -> FamilyResponse.of(family, myName))
				.collect(Collectors.toList())
			)
			.build();
	}
}
