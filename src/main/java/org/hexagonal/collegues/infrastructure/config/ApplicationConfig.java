package org.hexagonal.collegues.infrastructure.config;

import org.hexagonal.collegues.application.usecase.DeleteColleagueUseCase;
import org.hexagonal.collegues.application.usecase.GetColleagueUseCase;
import org.hexagonal.collegues.domain.ports.out.ColleagueRepositoryPort;
import org.hexagonal.collegues.application.usecase.CreateColleagueUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateColleagueUseCase createColleagueUseCaseImpl(ColleagueRepositoryPort colleagueRepositoryPort){
        return new CreateColleagueUseCase(colleagueRepositoryPort);
    }

    @Bean
    public GetColleagueUseCase getColleagueUseCase(ColleagueRepositoryPort colleagueRepositoryPort){
        return new GetColleagueUseCase(colleagueRepositoryPort);
    }

    @Bean
    public DeleteColleagueUseCase deleteColleagueUseCase(ColleagueRepositoryPort colleagueRepositoryPort){
        return new DeleteColleagueUseCase(colleagueRepositoryPort);
    }
}
