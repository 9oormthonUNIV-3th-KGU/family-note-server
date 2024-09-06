package goorm.kgu.familynote.domain.family.family.application;

import org.springframework.stereotype.Service;

import goorm.kgu.familynote.domain.family.family.domain.FamilyRepository;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyService {
	private final FamilyRepository familyRepository;
	private final FamilyMemberRepository familyMemberRepository;
}
