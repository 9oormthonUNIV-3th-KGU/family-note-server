package goorm.kgu.familynote.domain.family.member.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.domain.family.member.application.FamilyMemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/family/members")
@Tag(name = "Family Members", description = "가족 구성원 관련 api / 담당자 : 이한음")
public class FamilyMemberController {
	private final FamilyMemberService familyMemberService;

}
