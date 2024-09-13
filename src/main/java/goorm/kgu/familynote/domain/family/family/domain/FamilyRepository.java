package goorm.kgu.familynote.domain.family.family.domain;

import java.util.Optional;

public interface FamilyRepository {

	Family save(Family family);

	Optional<Family> findById(Long familyId);

	Family findFamilyByMemberUserId(Long userId);

}
