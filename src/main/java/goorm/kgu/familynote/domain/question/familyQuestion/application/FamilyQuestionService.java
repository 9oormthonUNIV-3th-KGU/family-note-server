package goorm.kgu.familynote.domain.question.familyQuestion.application;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.member.application.FamilyMemberService;
import goorm.kgu.familynote.domain.question.baseQuestion.application.BaseQuestionService;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestionRepository;
import goorm.kgu.familynote.domain.question.familyQuestion.presentation.response.FamilyQuestionResponse;
import goorm.kgu.familynote.domain.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyQuestionService {
    private final FamilyQuestionRepository familyQuestionRepository;
    private final FamilyMemberService familyMemberService;
    private final BaseQuestionService baseQuestionService;
    private final UserService userService;

    public FamilyQuestionResponse createFamilyQuestion() {
        /*
        FamilyAnswer 구현 하면서 추가할 세부 로직
        이전 질문이 없으면 바로 발행
        이전 질문이 있고, 아직 모든 가족 구성원이 답변하지 않았다면 예외처리
        이전 질문이 있고, 모든 가족 구정원이 답변하였다면 정상 발행
        */
        Long userId = userService.me().getId();
        Family family = familyMemberService.getFamilyByFamilyMember(userId);
        BaseQuestion baseQuestion = baseQuestionService.getRandomBaseQuestion();
        FamilyQuestion familyQuestion = FamilyQuestion.createFamilyQuestion(family, baseQuestion);
        familyQuestionRepository.save(familyQuestion);
        return FamilyQuestionResponse.of(familyQuestion);
    }
}
