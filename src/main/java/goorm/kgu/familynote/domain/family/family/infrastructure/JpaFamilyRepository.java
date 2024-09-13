package goorm.kgu.familynote.domain.family.family.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.family.family.domain.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaFamilyRepository extends JpaRepository<Family, Long> {

    @Query("SELECT f FROM Family f JOIN f.familyMembers fm WHERE fm.user.id = :userId")
    Family findFamilyByMemberUserId(@Param("userId") Long userId);

}
