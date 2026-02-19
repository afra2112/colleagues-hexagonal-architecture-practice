package org.hexagonal.collegues.domain.usecase;

import org.hexagonal.collegues.application.ports.in.CreateColleagueUseCase;
import org.hexagonal.collegues.application.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;

public class CreateColleagueUseCaseImpl implements CreateColleagueUseCase {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    public CreateColleagueUseCaseImpl(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    @Override
    public Colleague createColleague(Colleague colleague) {
        return colleagueRepositoryPort.save(colleague);
    }
}
