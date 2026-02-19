package org.hexagonal.collegues.application.usecase;

import org.hexagonal.collegues.domain.exception.BusinessException;
import org.hexagonal.collegues.domain.exception.ErrorCodeEnum;
import org.hexagonal.collegues.domain.ports.in.CreateColleagueUseCase;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;

public class CreateColleagueUseCaseImpl implements CreateColleagueUseCase {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    public CreateColleagueUseCaseImpl(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    @Override
    public Colleague createColleague(Colleague colleague) {
        if (colleagueRepositoryPort.existsByDni(colleague.dni())){
            throw new BusinessException(ErrorCodeEnum.USER_ALREADY_EXISTS, "Colleague already exists by dni: " + colleague.dni());
        }
        return colleagueRepositoryPort.save(colleague);
    }
}
