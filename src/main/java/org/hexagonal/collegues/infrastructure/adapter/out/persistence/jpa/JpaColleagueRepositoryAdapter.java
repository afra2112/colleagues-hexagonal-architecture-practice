package org.hexagonal.collegues.infrastructure.adapter.out.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.infrastructure.adapter.out.persistence.mapper.ColleagueMapper;
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

    @Override
    public boolean existsByDni(String dni) {
        return jpaColleagueRepository.existsByDni(dni);
    }
}
