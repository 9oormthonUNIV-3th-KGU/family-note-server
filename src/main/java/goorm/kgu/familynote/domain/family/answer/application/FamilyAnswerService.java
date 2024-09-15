package goorm.kgu.familynote.domain.family.answer.application;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswerRepository;
import goorm.kgu.familynote.domain.family.answer.presentation.request.FamilyAnswerCreateRequest;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerListResponse;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerPersistResponse;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerResponse;
import goorm.kgu.familynote.domain.family.question.application.FamilyQuestionService;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FamilyAnswerService {
    private final FamilyAnswerRepository familyAnswerRepository;
    private final FamilyQuestionService familyQuestionService;
    private final UserService userService;

    @Transactional
    public FamilyAnswerPersistResponse createFamilyAnswer(Long familyQuestionId, FamilyAnswerCreateRequest request) {
        User user = userService.me();
        FamilyQuestion familyQuestion = familyQuestionService.getFamilyQuestionById(familyQuestionId);
        FamilyAnswer familyAnswer = FamilyAnswer.createFamilyAnswer(familyQuestion, user, request.content());
        Long id = familyAnswerRepository.save(familyAnswer).getId();
        return FamilyAnswerPersistResponse.of(id);
    }

    @Transactional
    public FamilyAnswerListResponse getFamilyAnswers(Long familyQuestionId) {
        User user = userService.me();
        FamilyQuestion familyQuestion = familyQuestionService.getFamilyQuestionById(familyQuestionId);
        List<FamilyAnswer> familyAnswerList = familyAnswerRepository.findFamilyAnswersByFamilyQuestion(familyQuestion);
        boolean isUserInList = familyAnswerList.stream()
                .anyMatch(familyAnswer -> familyAnswer.getUser().getId().equals(user.getId()));
        return FamilyAnswerListResponse.of(isUserInList, familyAnswerList);
    }

}
