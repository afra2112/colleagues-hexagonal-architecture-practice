package org.hexagonal.collegues.domain.service;

import org.hexagonal.collegues.application.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.model.Colleague;

public class CreateColleagueService {

    private final ColleagueRepositoryPort colleagueRepositoryPort;

    CreateColleagueService(ColleagueRepositoryPort colleagueRepositoryPort){
        this.colleagueRepositoryPort = colleagueRepositoryPort;
    }

    public void execute(Colleague colleague){
        //here i could add validation logic and throw exceptions if needed
        this.colleagueRepositoryPort.save(colleague);
    }
}
