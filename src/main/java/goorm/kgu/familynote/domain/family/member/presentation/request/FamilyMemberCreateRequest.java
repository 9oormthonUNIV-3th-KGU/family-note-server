package goorm.kgu.familynote.domain.family.member.presentation.request;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public record FamilyMemberCreateRequest(
	@Schema(description = "가족 구성원 유저 ID", example = "[1, 2, 3]", requiredMode = REQUIRED)
	List<Long> userIds,

	@Schema(description = "가족 그룹 이름", example = "행복한 우리집", requiredMode = REQUIRED)
	String familyName
) {
}
