package goorm.kgu.familynote.domain.family.family.infrastructure;

import org.springframework.stereotype.Repository;

import goorm.kgu.familynote.domain.family.family.domain.FamilyRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FamilyRepositoryImpl implements FamilyRepository {
	private final JpaFamilyRepository jpaFamilyRepository;

}
