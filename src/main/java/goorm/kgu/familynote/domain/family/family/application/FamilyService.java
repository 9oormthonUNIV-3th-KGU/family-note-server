package goorm.kgu.familynote.domain.family.family.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.family.domain.FamilyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyService {
	private final FamilyRepository familyRepository;

	@Transactional
	public Family createFamily() {
		Family family = Family.createNewFamily();
		return familyRepository.save(family);
	}
}
