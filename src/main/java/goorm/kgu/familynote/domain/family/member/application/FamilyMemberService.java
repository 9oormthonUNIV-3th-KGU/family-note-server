package goorm.kgu.familynote.domain.family.member.application;

import org.springframework.stereotype.Service;

import goorm.kgu.familynote.domain.family.member.domain.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {
	private final FamilyMemberRepository familyMemberRepository;
}
