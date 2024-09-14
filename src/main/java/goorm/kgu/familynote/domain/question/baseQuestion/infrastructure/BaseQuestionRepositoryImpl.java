package goorm.kgu.familynote.domain.question.baseQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestionRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BaseQuestionRepositoryImpl implements BaseQuestionRepository {
    private final JpaBaseQuestionRepository jpaBaseQuestionRepository;

    @Override
    public BaseQuestion save(BaseQuestion baseQuestion) {
        return jpaBaseQuestionRepository.save(baseQuestion);
    }

    @Override
    public Long countBaseQuestions() {
        return jpaBaseQuestionRepository.count();
    }

    @Override
    public Optional<BaseQuestion> findById(Long id) {
        return jpaBaseQuestionRepository.findById(id);
    }

    @Override
    public List<BaseQuestion> findAll() {
        return jpaBaseQuestionRepository.findAll();
    }
}
