package goorm.kgu.familynote.domain.family.question.infrastructure;

import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestionRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FamilyQuestionRepositoryImpl implements FamilyQuestionRepository {
    private final JpaFamilyQuestionRepository jpaFamilyQuestionRepository;

    @Override
    public Optional<FamilyQuestion> findById(Long id) {
        return jpaFamilyQuestionRepository.findById(id);
    }

    @Override
    public FamilyQuestion findLatestCreatedFamilyQuestionByFamilyId(Long familyId) {
        return jpaFamilyQuestionRepository.findTopByFamilyIdOrderByCreatedAtDesc(familyId);
    }

    @Override
    public FamilyQuestion save(FamilyQuestion familyQuestion) {
        return jpaFamilyQuestionRepository.save(familyQuestion);
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
