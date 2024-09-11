package goorm.kgu.familynote.domain.question.familyQuestion.domain;


import java.util.List;

public interface FamilyQuestionRepository {

    FamilyQuestion save(FamilyQuestion familyQuestion);

    List<Long> findUsedBaseQuestionIdsByFamilyId(Long familyId);

    List<FamilyQuestion> findAllByFamilyId(Long familyId);

}
