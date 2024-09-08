package goorm.kgu.familynote.domain.family.family.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goorm.kgu.familynote.domain.family.family.application.FamilyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/family")
@Tag(name = "Family", description = "가족 그룹 관련 api / 담당자 : 이한음")
public class FamilyController {
	private final FamilyService familyService;

}
