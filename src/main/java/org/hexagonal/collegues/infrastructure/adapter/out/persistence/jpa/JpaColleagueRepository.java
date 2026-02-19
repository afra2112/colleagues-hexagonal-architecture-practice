package org.hexagonal.collegues.infrastructure.adapter.out.persistence.jpa;

import org.hexagonal.collegues.infrastructure.adapter.out.persistence.entity.ColleagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaColleagueRepository extends JpaRepository<ColleagueEntity, Long> {

    boolean existsByDni(String dni);
}
