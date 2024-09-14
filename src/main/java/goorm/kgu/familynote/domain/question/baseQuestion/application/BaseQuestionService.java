package goorm.kgu.familynote.domain.question.baseQuestion.application;

import goorm.kgu.familynote.common.util.RandomNumberUtils;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestionRepository;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.BaseQuestionNotFoundException;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.InvalidBaseQuestionCountException;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.NoMoreBaseQuestionException;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.request.BaseQuestionCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionPersistListResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BaseQuestionService {
    private final BaseQuestionRepository baseQuestionRepository;

    @Transactional
    public BaseQuestionPersistListResponse saveBaseQuestions(List<BaseQuestionCreateRequest> requests) {
        List<Long> baseQuestionResponseIdList = requests.stream()
                .map(this::saveBaseQuestion)
                .collect(Collectors.toList());
        return BaseQuestionPersistListResponse.of(baseQuestionResponseIdList);
    }

    private Long saveBaseQuestion(BaseQuestionCreateRequest request) {
        BaseQuestion baseQuestion = BaseQuestion.create(request.content());
        baseQuestionRepository.save(baseQuestion);
        return baseQuestion.getId();
    }

    public BaseQuestion getRandomBaseQuestion(List<Long> usedBaseQuestionIds) {
        Long numberOfBaseQuestion = baseQuestionRepository.countBaseQuestions();
        if (numberOfBaseQuestion <= 0) {
            throw new InvalidBaseQuestionCountException();
        }

        List<BaseQuestion> unusedBaseQuestions = baseQuestionRepository.findAll()
                .stream()
                .filter(baseQuestion -> !usedBaseQuestionIds.contains(baseQuestion.getId()))
                .toList();

        if (unusedBaseQuestions.isEmpty()) {
            throw new NoMoreBaseQuestionException();
        }

        int questionIndex = RandomNumberUtils.getRandomIntInRange(0, unusedBaseQuestions.size());
        return unusedBaseQuestions.get(questionIndex);
    }

    public BaseQuestion getBaseQuestionById(Long id) {
        return baseQuestionRepository.findById(id)
                .orElseThrow(BaseQuestionNotFoundException::new);
    }

}
