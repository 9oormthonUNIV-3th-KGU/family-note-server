package goorm.kgu.familynote.domain.question.baseQuestion.application;

import goorm.kgu.familynote.common.util.RandomNumberUtils;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestionRepository;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.exception.BaseQuestionNotFoundException;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.request.BaseQuestionCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponse;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponseList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BaseQuestionService {
    private final BaseQuestionRepository baseQuestionRepository;

    @Transactional
    public BaseQuestionResponseList saveBaseQuestions(List<BaseQuestionCreateRequest> requests) {
        List<BaseQuestionResponse> baseQuestionResponseList = requests.stream()
                .map(this::saveBaseQuestion)
                .collect(Collectors.toList());
        return BaseQuestionResponseList.of(baseQuestionResponseList);
    }

    private BaseQuestionResponse saveBaseQuestion(BaseQuestionCreateRequest request) {
        BaseQuestion baseQuestion = BaseQuestion.create(request.content());
        baseQuestionRepository.save(baseQuestion);
        return BaseQuestionResponse.of(baseQuestion);
    }

    public BaseQuestion getRandomBaseQuestion() {
        // 중복되는 질문 없도록 로직 추가
        Long numberOfBaseQuestion = baseQuestionRepository.countBaseQuestions();
        // numberOfBaseQuestion <= 0이면 예외처리
        Long baseQuestionId = RandomNumberUtils.getRandomLongInRange(numberOfBaseQuestion);
        return getBaseQuestionById(baseQuestionId);
    }

    public BaseQuestion getBaseQuestionById(Long id) {
        return baseQuestionRepository.findById(id)
                .orElseThrow(BaseQuestionNotFoundException::new);
    }

}
