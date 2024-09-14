package goorm.kgu.familynote.domain.family.question.domain;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FamilyQuestionRepository {

    FamilyQuestion save(FamilyQuestion familyQuestion);

    List<FamilyQuestion> findAllByFamilyId(Long familyId);

    Page<FamilyQuestion> findAllByFamilyId(Long familyId, Pageable pageable);

    Optional<FamilyQuestion> findById(Long id);

}
