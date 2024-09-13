package goorm.kgu.familynote.domain.family.familyQuestion.domain;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FamilyQuestionRepository {

    FamilyQuestion save(FamilyQuestion familyQuestion);

    List<Long> findUsedBaseQuestionIdsByFamilyId(Long familyId);

    List<FamilyQuestion> findAllByFamilyId(Long familyId);

    Page<FamilyQuestion> findAllByFamilyId(Long familyId, Pageable pageable);

}
