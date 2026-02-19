package org.hexagonal.collegues.application.usecase;

import org.hexagonal.collegues.domain.exception.BusinessException;
import org.hexagonal.collegues.domain.exception.ErrorCodeEnum;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;

public class DeleteColleagueUseCase {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    public DeleteColleagueUseCase(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    public void deleteColleagueByDni(String dni){
        if (!colleagueRepositoryPort.existsByDni(dni)){
            throw new BusinessException(ErrorCodeEnum.ENTITY_NOT_FOUND, "Colleague not found by dni: " + dni);
        }
        colleagueRepositoryPort.deleteByDni(dni);
    }
}
