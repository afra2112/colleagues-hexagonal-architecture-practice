package org.hexagonal.collegues.infrastructure.config;

import org.hexagonal.collegues.application.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.domain.service.ColleagueService;
import org.hexagonal.collegues.domain.usecase.CreateColleagueUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ColleagueService colleagueService(ColleagueRepositoryPort colleagueRepositoryPort){
        return new ColleagueService(
                new CreateColleagueUseCaseImpl(colleagueRepositoryPort)
        );
    }
}
