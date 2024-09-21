package goorm.kgu.familynote.domain.family.member.infrastructure;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.user.domain.User;
import org.springframework.stereotype.Repository;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FamilyMemberRepositoryImpl implements FamilyMemberRepository {
	private final JpaFamilyMemberRepository jpaFamilyMemberRepository;

	@Override
	public FamilyMember save(FamilyMember familyMember) {
		return jpaFamilyMemberRepository.save(familyMember);
	}

	@Override
	public Integer countFamilyMemberByFamilyId(Long familyId) {
		return jpaFamilyMemberRepository.countByFamilyId(familyId);
	}

}
