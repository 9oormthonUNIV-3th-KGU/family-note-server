package goorm.kgu.familynote.domain.question.familyQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFamilyQuestionRepository extends JpaRepository<FamilyQuestion, Long> {

}
