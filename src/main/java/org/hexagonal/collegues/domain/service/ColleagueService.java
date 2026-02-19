package org.hexagonal.collegues.domain.service;

import org.hexagonal.collegues.application.ports.in.CreateColleagueUseCase;
import org.hexagonal.collegues.domain.model.Colleague;

public class ColleagueService implements CreateColleagueUseCase {

    private final CreateColleagueUseCase createColleagueUseCase;

    public ColleagueService(CreateColleagueUseCase createColleagueUseCase){
        this.createColleagueUseCase = createColleagueUseCase;
    }

    @Override
    public Colleague createColleague(Colleague colleague) {
        return createColleagueUseCase.createColleague(colleague);
    }
}
