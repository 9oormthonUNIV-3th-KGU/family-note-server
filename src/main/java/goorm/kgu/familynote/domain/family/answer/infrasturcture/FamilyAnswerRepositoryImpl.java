package goorm.kgu.familynote.domain.family.answer.infrasturcture;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswerRepository;
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

}
