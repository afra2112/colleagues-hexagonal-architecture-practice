package org.hexagonal.collegues.application.usecase;

import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;

public class UpdateColleagueUseCase {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    public UpdateColleagueUseCase(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    public Colleague updateColleague(Colleague colleague, String dni){
        return colleagueRepositoryPort.updateColleague(colleague, dni);
    }
}
