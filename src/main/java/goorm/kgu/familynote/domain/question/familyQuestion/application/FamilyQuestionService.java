package goorm.kgu.familynote.domain.question.familyQuestion.application;

import goorm.kgu.familynote.common.response.PageableResponse;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.member.application.FamilyMemberService;
import goorm.kgu.familynote.domain.question.baseQuestion.application.BaseQuestionService;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.question.familyQuestion.domain.FamilyQuestionRepository;
import goorm.kgu.familynote.domain.question.familyQuestion.presentation.response.FamilyQuestionResponse;
import goorm.kgu.familynote.domain.user.application.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FamilyQuestionService {
    private final FamilyQuestionRepository familyQuestionRepository;
    private final FamilyMemberService familyMemberService;
    private final BaseQuestionService baseQuestionService;
    private final UserService userService;

    @Transactional
    public FamilyQuestionResponse createFamilyQuestion() {
        /*
        FamilyAnswer 구현 하면서 추가할 세부 로직
        이전 질문이 없으면 바로 발행
        이전 질문이 있고, 아직 모든 가족 구성원이 답변하지 않았다면 예외처리
        이전 질문이 있고, 모든 가족 구정원이 답변하였다면 정상 발행
        */
        Long userId = userService.me().getId();
        Family family = familyMemberService.getFamilyByFamilyMember(userId);

        List<Long> usedBaseQuestionIds = getBaseQuestionIdsByFamilyId(family.getId());
        BaseQuestion baseQuestion = baseQuestionService.getRandomBaseQuestion(usedBaseQuestionIds);
        FamilyQuestion familyQuestion = FamilyQuestion.createFamilyQuestion(family, baseQuestion);
        familyQuestionRepository.save(familyQuestion);
        return FamilyQuestionResponse.of(familyQuestion);
    }
    @Transactional
    public PageableResponse<FamilyQuestionResponse> getFamilyQuestions(int page, int size) {
        Long userId = userService.me().getId();
        Family family = familyMemberService.getFamilyByFamilyMember(userId);
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<FamilyQuestion> familyQuestions = getAllFamilyQuestionsByFamilyId(family.getId(), pageable);
        Page<FamilyQuestionResponse> familyQuestionResponses = familyQuestions.map(FamilyQuestionResponse::of);
        return PageableResponse.of(familyQuestionResponses);
    }

    public List<FamilyQuestion> getAllFamilyQuestionsByFamilyId(Long familyId) {
        return familyQuestionRepository.findAllByFamilyId(familyId);
    }

    public List<Long> getBaseQuestionIdsByFamilyId(Long familyId) {
        return getAllFamilyQuestionsByFamilyId(familyId).stream()
                .map(familyQuestion -> familyQuestion.getBaseQuestion().getId())
                .toList();
    }

    public Page<FamilyQuestion> getAllFamilyQuestionsByFamilyId(Long familyId, Pageable pageable) {
        return familyQuestionRepository.findAllByFamilyId(familyId, pageable);
    }
}
