package goorm.kgu.familynote.domain.question.baseQuestion.domain;


import java.util.Optional;

public interface BaseQuestionRepository {

    BaseQuestion save(BaseQuestion baseQuestion);

    Long countBaseQuestions();

    Optional<BaseQuestion> findById(Long id);

}
