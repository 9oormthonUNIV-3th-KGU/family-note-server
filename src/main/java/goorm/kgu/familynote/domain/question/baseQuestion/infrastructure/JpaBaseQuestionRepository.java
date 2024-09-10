package goorm.kgu.familynote.domain.question.baseQuestion.infrastructure;

import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBaseQuestionRepository extends JpaRepository<BaseQuestion, Long> {
}
