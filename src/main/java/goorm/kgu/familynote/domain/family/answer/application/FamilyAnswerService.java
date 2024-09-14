package goorm.kgu.familynote.domain.family.answer.application;

import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswerRepository;
import goorm.kgu.familynote.domain.family.answer.presentation.request.FamilyAnswerCreateRequest;
import goorm.kgu.familynote.domain.family.answer.presentation.response.FamilyAnswerPersistResponse;
import goorm.kgu.familynote.domain.family.question.application.FamilyQuestionService;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.user.application.UserService;
import goorm.kgu.familynote.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyAnswerService {
    private final FamilyAnswerRepository familyAnswerRepository;
    private final FamilyQuestionService familyQuestionService;
    private final UserService userService;

    public FamilyAnswerPersistResponse createFamilyAnswer(FamilyAnswerCreateRequest request) {
        User user = userService.me();
        Long familyQuestionId = request.familyQuestionId();
        FamilyQuestion familyQuestion = familyQuestionService.getFamilyQuestionById(familyQuestionId);
        FamilyAnswer familyAnswer = FamilyAnswer.createFamilyAnswer(familyQuestion, user, request.content());
        Long id = saveFamilyAnswer(familyAnswer);
        return FamilyAnswerPersistResponse.of(id);
    }

    public Long saveFamilyAnswer(FamilyAnswer familyAnswer) {
        return familyAnswerRepository.save(familyAnswer).getId();
    }
}
