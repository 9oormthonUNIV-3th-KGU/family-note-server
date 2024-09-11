package goorm.kgu.familynote.domain.question.familyQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaFamilyQuestionRepository extends JpaRepository<FamilyQuestion, Long> {

    List<Long> findBaseQuestionIdsByFamilyId(Long familyId);

    List<FamilyQuestion> findAllByFamilyId(Long familyId);

    Page<FamilyQuestion> findAllByFamilyId(Long familyId, Pageable pageable);

}
