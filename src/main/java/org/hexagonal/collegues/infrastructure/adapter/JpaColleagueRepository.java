package org.hexagonal.collegues.infrastructure.adapter;

import org.hexagonal.collegues.infrastructure.entity.ColleagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaColleagueRepository extends JpaRepository<ColleagueEntity, Long> {
}
