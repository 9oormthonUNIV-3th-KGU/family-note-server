package goorm.kgu.familynote.domain.family.family.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goorm.kgu.familynote.domain.family.family.domain.Family;

public interface JpaFamilyRepository extends JpaRepository<Family, Long> {
}
