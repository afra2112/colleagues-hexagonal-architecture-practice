package org.hexagonal.collegues.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import org.hexagonal.collegues.application.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.infrastructure.entity.ColleagueEntity;
import org.hexagonal.collegues.infrastructure.mapper.ColleagueMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaColleagueRepositoryAdapter implements ColleagueRepositoryPort {

    private final JpaColleagueRepository jpaColleagueRepository;
    private final ColleagueMapper colleagueMapper;

    @Override
    public Colleague save(Colleague colleague) {
        return colleagueMapper.toPOJO(
                jpaColleagueRepository.save(colleagueMapper.toEntity(colleague))
        );
    }
}
