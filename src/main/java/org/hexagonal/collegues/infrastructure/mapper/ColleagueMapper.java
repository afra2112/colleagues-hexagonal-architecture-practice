package org.hexagonal.collegues.infrastructure.mapper;

import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.infrastructure.entity.ColleagueEntity;
import org.springframework.stereotype.Component;

@Component
public class ColleagueMapper {

    public ColleagueEntity toEntity(Colleague colleague){
        return new ColleagueEntity(colleague.id(), colleague.name(), colleague.dni());
    }

    public Colleague toPOJO(ColleagueEntity entity){
        return new Colleague(entity.getColleagueId(), entity.getName(), entity.getDni());
    }
}
