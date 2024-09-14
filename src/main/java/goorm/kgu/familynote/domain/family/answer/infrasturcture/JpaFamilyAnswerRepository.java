package goorm.kgu.familynote.domain.family.answer.infrasturcture;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFamilyAnswerRepository extends JpaRepository<FamilyAnswer, Long> {

}
