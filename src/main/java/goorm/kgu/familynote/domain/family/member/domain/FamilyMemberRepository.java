package goorm.kgu.familynote.domain.family.member.domain;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.user.domain.User;

public interface FamilyMemberRepository {

	FamilyMember save(FamilyMember familyMember);

	Integer countFamilyMemberByFamilyId(Long familyId);

	Boolean existsByUserAndFamily(User user, Family family);

}
