package goorm.kgu.familynote.domain.family.answer.domain;

import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import java.util.List;

public interface FamilyAnswerRepository {

    FamilyAnswer save(FamilyAnswer familyAnswer);

    List<FamilyAnswer> findFamilyAnswersByFamilyQuestion(FamilyQuestion familyQuestion);

}
