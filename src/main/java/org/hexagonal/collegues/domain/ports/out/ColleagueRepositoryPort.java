package org.hexagonal.collegues.domain.ports.out;

import org.hexagonal.collegues.domain.model.Colleague;

public interface ColleagueRepositoryPort {

    Colleague save(Colleague colleague);

    Colleague getByDni(String dni);

    Colleague updateColleague(Colleague colleague, String dni);

    boolean existsByDni(String dni);

    void deleteByDni(String dni);
}
