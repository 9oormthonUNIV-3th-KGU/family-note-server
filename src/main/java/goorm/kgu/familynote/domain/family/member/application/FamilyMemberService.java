package goorm.kgu.familynote.domain.family.member.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.family.family.application.FamilyService;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.family.presentation.response.FamilyPersistResponse;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMemberRepository;
import goorm.kgu.familynote.domain.family.member.presentation.request.FamilyMemberCreateRequest;
import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {
	private final FamilyMemberRepository familyMemberRepository;
	private final FamilyService familyService;
	private final UserService userService;

	@Transactional
	public FamilyPersistResponse saveFamilyMember(FamilyMemberCreateRequest request) {
		Family family = familyService.createFamily();
		List<Long> users = request.userIds();
		users.forEach(userId -> {
			User user = userService.getUserById(userId);
			FamilyMember familyMember = FamilyMember.create(family, user);
			familyMemberRepository.save(familyMember);
		});
		return FamilyPersistResponse.of(family.getId());
	}
}
