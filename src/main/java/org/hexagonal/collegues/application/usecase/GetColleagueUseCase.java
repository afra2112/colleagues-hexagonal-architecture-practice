package org.hexagonal.collegues.application.usecase;

import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;

public class GetColleagueUseCase {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    public GetColleagueUseCase(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    public Colleague getColleagueByDni(String dni){
        return colleagueRepositoryPort.getByDni(dni);
    }
}
