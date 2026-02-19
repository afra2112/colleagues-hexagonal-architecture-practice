package org.hexagonal.collegues.domain.ports.out;

import org.hexagonal.collegues.domain.model.Colleague;

public interface ColleagueRepositoryPort {

    Colleague save(Colleague colleague);

    boolean existsByDni(String dni);
}
