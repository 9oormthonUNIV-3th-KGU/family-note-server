package goorm.kgu.familynote.domain.family.member.infrastructure;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;

public interface JpaFamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

    FamilyMember findByUserId(Long userId);

    Integer countByFamilyId(Long familyId);

    Boolean existsByUserAndFamily(User user, Family family);

}
