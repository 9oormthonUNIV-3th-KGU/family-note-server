package goorm.kgu.familynote.domain.family.family.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.family.domain.FamilyRepository;
import goorm.kgu.familynote.domain.family.family.presentation.exception.FamilyNotFoundException;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyListResponse;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyResponse;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyService {
	private final FamilyRepository familyRepository;
	private final UserService userService;

	@Transactional
	public FamilyResponse getFamily(Long familyId) {
		Family family = getFamilyById(familyId);
		String nickName = userService.me().getNickname();
		return FamilyResponse.of(family, nickName);
	}

	@Transactional
	public Family createFamily(String familyName) {
		Family family = Family.createNewFamily(familyName);
		return familyRepository.save(family);
	}

	@Transactional
	public FamilyListResponse getMyFamilyList() {
		User user = userService.me();
		List<FamilyMember> familyMembers = user.getFamilyMembers();
		List<Family> family = familyMembers.stream()
			.map(FamilyMember::getFamily)
			.toList();
		return FamilyListResponse.of(family, user.getNickname());
	}

	public Family getFamilyById(Long familyId) {
		return familyRepository.findById(familyId)
			.orElseThrow(FamilyNotFoundException::new);
	}

	public Family getFamilyByFamilyMember(Long userId) {
		Family family = familyRepository.findFamilyByMemberUserId(userId);
		return family;
	}

}
