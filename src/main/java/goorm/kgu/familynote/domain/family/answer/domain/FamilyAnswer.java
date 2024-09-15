package goorm.kgu.familynote.domain.family.answer.domain;

import goorm.kgu.familynote.domain.family.answer.presentation.request.FamilyAnswerCreateRequest;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.question.domain.FamilyQuestion;
import goorm.kgu.familynote.domain.question.baseQuestion.domain.BaseQuestion;
import goorm.kgu.familynote.domain.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@Table(name = "family_answer")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FamilyAnswer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_question_id")
    private FamilyQuestion familyQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 1000, nullable = false)
    @NotNull(message = "가족 답변은 null일 수 없습니다.")
    private String content;

    public static FamilyAnswer createFamilyAnswer(FamilyQuestion familyQuestion, User user, String content) {
        return FamilyAnswer.builder()
                .familyQuestion(familyQuestion)
                .user(user)
                .content(content)
                .build();
    }

}
