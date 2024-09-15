package goorm.kgu.familynote.domain.family.answer.infrasturcture;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFamilyAnswerRepository extends JpaRepository<FamilyAnswer, Long> {

    List<FamilyAnswer> findAllByFamilyQuestion(FamilyQuestion familyQuestion);

}
