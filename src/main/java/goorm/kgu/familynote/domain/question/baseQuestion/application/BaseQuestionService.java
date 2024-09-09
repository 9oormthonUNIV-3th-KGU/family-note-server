package goorm.kgu.familynote.domain.question.baseQuestion.application;

import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestionRepository;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.request.BaseQuestionCreateRequest;
import goorm.kgu.familynote.domain.question.baseQuestion.presentation.response.BaseQuestionResponse;
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
    public List<BaseQuestionResponse> saveBaseQuestions(List<BaseQuestionCreateRequest> requests) {
        return requests.stream()
                .map(this::saveBaseQuestion)
                .collect(Collectors.toList());
    }

    private BaseQuestionResponse saveBaseQuestion(BaseQuestionCreateRequest request) {
        BaseQuestion baseQuestion = BaseQuestion.create(request.content());
        baseQuestionRepository.save(baseQuestion);
        return BaseQuestionResponse.of(baseQuestion);
    }

}
