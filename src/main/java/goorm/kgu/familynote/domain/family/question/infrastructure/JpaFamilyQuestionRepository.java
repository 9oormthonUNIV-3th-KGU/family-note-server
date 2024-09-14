package goorm.kgu.familynote.domain.family.question.infrastructure;

import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFamilyQuestionRepository extends JpaRepository<FamilyQuestion, Long> {

    List<FamilyQuestion> findAllByFamilyId(Long familyId);

    Page<FamilyQuestion> findAllByFamilyId(Long familyId, Pageable pageable);

    FamilyQuestion findTopByFamilyIdOrderByCreatedAtDesc(Long familyId);

}
