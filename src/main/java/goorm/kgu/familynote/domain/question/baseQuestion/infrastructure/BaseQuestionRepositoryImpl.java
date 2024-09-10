package goorm.kgu.familynote.domain.question.baseQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestionRepository;
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
}
