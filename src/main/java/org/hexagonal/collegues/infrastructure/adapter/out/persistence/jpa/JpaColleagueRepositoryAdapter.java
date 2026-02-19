package org.hexagonal.collegues.infrastructure.adapter.out.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.hexagonal.collegues.domain.exception.BusinessException;
import org.hexagonal.collegues.domain.exception.ErrorCodeEnum;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.infrastructure.adapter.out.persistence.mapper.ColleagueMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public Colleague getByDni(String dni) {
        return colleagueMapper.toPOJO(jpaColleagueRepository.findByDni(dni).orElseThrow(
                () -> new BusinessException(ErrorCodeEnum.ENTITY_NOT_FOUND, "Colleague not found by dni: " + dni)
        ));
    }

    @Override
    public boolean existsByDni(String dni) {
        return jpaColleagueRepository.existsByDni(dni);
    }

    @Override
    @Transactional
    public void deleteByDni(String dni) {
        jpaColleagueRepository.deleteByDni(dni);
    }
}
