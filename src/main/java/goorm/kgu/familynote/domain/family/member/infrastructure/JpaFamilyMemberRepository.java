package goorm.kgu.familynote.domain.family.member.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;

public interface JpaFamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

    FamilyMember findByUserId(Long userId);

}
