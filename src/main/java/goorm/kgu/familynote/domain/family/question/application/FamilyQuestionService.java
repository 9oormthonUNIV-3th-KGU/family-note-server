package goorm.kgu.familynote.domain.family.question.application;

import goorm.kgu.familynote.common.response.PageableResponse;
import goorm.kgu.familynote.domain.family.family.application.FamilyService;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestionRepository;
import goorm.kgu.familynote.domain.family.question.presentation.exception.FamilyQuestionNotFoundException;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionPageResponse;
import goorm.kgu.familynote.domain.family.question.presentation.response.FamilyQuestionResponse;
import goorm.kgu.familynote.domain.question.baseQuestion.application.BaseQuestionService;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
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
    private final FamilyService familyService;
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
        Family family = familyService.getFamilyByFamilyMember(userId);

        List<Long> usedBaseQuestionIds = getBaseQuestionIdsByFamilyId(family.getId());
        BaseQuestion baseQuestion = baseQuestionService.getRandomBaseQuestion(usedBaseQuestionIds);
        FamilyQuestion familyQuestion = FamilyQuestion.createFamilyQuestion(family, baseQuestion);
        familyQuestionRepository.save(familyQuestion);
        return FamilyQuestionResponse.of(familyQuestion);
    }

    @Transactional
    public FamilyQuestionPageResponse getFamilyQuestions(int page, int size) {
        Long userId = userService.me().getId();
        Family family = familyService.getFamilyByFamilyMember(userId);
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<FamilyQuestion> familyQuestionsPage = getAllFamilyQuestionsByFamilyId(family.getId(), pageable);
        List<FamilyQuestionResponse> familyQuestionResponses = familyQuestionsPage
                .stream()
                .map(FamilyQuestionResponse::of)
                .collect(Collectors.toList());
        PageableResponse pageableResponse = PageableResponse.of(pageable, familyQuestionsPage.getTotalElements());
        return new FamilyQuestionPageResponse(familyQuestionResponses, pageableResponse);
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

    public FamilyQuestion getFamilyQuestionById(Long id) {
        return familyQuestionRepository.findById(id)
                .orElseThrow(FamilyQuestionNotFoundException::new);
    }

}
