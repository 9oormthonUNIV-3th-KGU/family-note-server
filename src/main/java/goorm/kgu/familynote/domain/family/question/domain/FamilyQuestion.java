package goorm.kgu.familynote.domain.family.question.domain;

import goorm.kgu.familynote.common.domain.BaseTimeEntity;
import goorm.kgu.familynote.domain.family.answer.domain.FamilyAnswer;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@Table(name = "family_question")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FamilyQuestion extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_question_id")
    private BaseQuestion baseQuestion;

    @OneToMany(mappedBy = "familyQuestion", fetch = FetchType.LAZY)
    private List<FamilyAnswer> familyAnswers;

    public Integer getNumberOfRespondents() {
        return this.familyAnswers.size();
    }

    public static FamilyQuestion createFamilyQuestion(Family family, BaseQuestion baseQuestion) {
        return FamilyQuestion.builder()
            .family(family)
            .baseQuestion(baseQuestion)
            .build();
    }

}
