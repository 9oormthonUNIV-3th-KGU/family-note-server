package goorm.kgu.familynote.domain.question.familyQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestionRepository;
import java.util.List;
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

    @Override
    public List<Long> findUsedBaseQuestionIdsByFamilyId(Long familyId) {
        return jpaFamilyQuestionRepository.findBaseQuestionIdsByFamilyId(familyId);
    }

    @Override
    public List<FamilyQuestion> findAllByFamilyId(Long familyId) {
        return jpaFamilyQuestionRepository.findAllByFamilyId(familyId);
    }
}
