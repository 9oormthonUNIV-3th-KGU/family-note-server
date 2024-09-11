package goorm.kgu.familynote.domain.question.familyQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FamilyQuestionRepositoryImpl implements FamilyQuestionRepository {
    private final JpaFamilyQuestionRepository jpaFamilyQuestionRepository;

    @Override
    public FamilyQuestion save(FamilyQuestion familyQuestion) {
        return jpaFamilyQuestionRepository.save(familyQuestion);
    }
}
