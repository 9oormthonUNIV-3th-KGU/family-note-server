package goorm.kgu.familynote.domain.family.family.domain;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import goorm.kgu.familynote.common.domain.BaseTimeEntity;
import goorm.kgu.familynote.domain.family.member.domain.FamilyMember;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@Table(name = "family")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Family extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String familyName;

	@OneToMany(mappedBy = "family", fetch = FetchType.LAZY)
	private List<FamilyMember> familyMembers;

	public static Family createNewFamily(String familyName) {
		return Family.builder()
			.familyName(familyName)
			.build();
	}

}
