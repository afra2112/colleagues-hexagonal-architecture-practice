package org.hexagonal.collegues.infrastructure.config;

import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.application.usecase.CreateColleagueUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateColleagueUseCaseImpl createColleagueUseCaseImpl(ColleagueRepositoryPort colleagueRepositoryPort){
        return new CreateColleagueUseCaseImpl(colleagueRepositoryPort);
    }
}
