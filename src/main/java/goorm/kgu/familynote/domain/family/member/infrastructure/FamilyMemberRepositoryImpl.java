package goorm.kgu.familynote.domain.family.member.infrastructure;

import org.springframework.stereotype.Repository;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FamilyMemberRepositoryImpl implements FamilyMemberRepository {
	private final JpaFamilyMemberRepository jpaFamilyMemberRepository;
}
