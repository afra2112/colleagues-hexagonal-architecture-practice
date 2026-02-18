package org.hexagonal.collegues.application.ports.out;

import org.hexagonal.collegues.domain.model.Colleague;

public interface ColleagueRepositoryPort {

    Colleague save(Colleague colleague);
}
