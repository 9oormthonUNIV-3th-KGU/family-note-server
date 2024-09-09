package goorm.kgu.familynote.domain.question.baseQuestion.domain;

import goorm.kgu.familynote.common.domain.BaseTimeEntity;
import goorm.kgu.familynote.domain.family.family.domain.Family;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import goorm.kgu.familynote.domain.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@Table(name = "base_question")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseQuestion extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    public static BaseQuestion create(String content) {
        return BaseQuestion.builder()
                .content(content)
                .build();
    }

}
