package org.hexagonal.collegues.application.ports.in;

import org.hexagonal.collegues.domain.model.Colleague;

public interface CreateColleagueUseCase {

    Colleague createColleague(Colleague colleague);
}
