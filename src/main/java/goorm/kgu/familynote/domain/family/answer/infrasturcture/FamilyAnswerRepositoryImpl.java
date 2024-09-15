package goorm.kgu.familynote.domain.family.answer.infrasturcture;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswerRepository;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FamilyAnswerRepositoryImpl implements FamilyAnswerRepository {
    private final JpaFamilyAnswerRepository jpaFamilyAnswerRepository;

    @Override
    public FamilyAnswer save(FamilyAnswer familyAnswer) {
        return jpaFamilyAnswerRepository.save(familyAnswer);
    }

    @Override
    public List<FamilyAnswer> findFamilyAnswersByFamilyQuestion(FamilyQuestion familyQuestion) {
        return jpaFamilyAnswerRepository.findAllByFamilyQuestion(familyQuestion);
    }

}
