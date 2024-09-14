package goorm.kgu.familynote.domain.family.family.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.family.domain.FamilyRepository;
import goorm.kgu.familynote.domain.family.family.presentation.exception.FamilyNotFoundException;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyResponse;
import goorm.kgu.familynote.domain.user.application.UserService;
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
	public Family createFamily() {
		Family family = Family.createNewFamily();
		return familyRepository.save(family);
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
