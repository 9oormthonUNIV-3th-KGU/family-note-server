package goorm.kgu.familynote.domain.family.familyQuestion.infrastructure;

import goorm.kgu.familynote.domain.family.familyQuestion.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.family.familyQuestion.domain.FamilyQuestionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<FamilyQuestion> findAllByFamilyId(Long familyId, Pageable pageable) {
        return jpaFamilyQuestionRepository.findAllByFamilyId(familyId, pageable);
    }
}
