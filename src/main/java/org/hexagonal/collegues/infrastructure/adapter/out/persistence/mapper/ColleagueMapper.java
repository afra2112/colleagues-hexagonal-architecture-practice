package org.hexagonal.collegues.infrastructure.adapter.out.persistence.mapper;

import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request.ColleagueRequest;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.ColleagueResponse;
import org.hexagonal.collegues.infrastructure.adapter.out.persistence.entity.ColleagueEntity;
import org.springframework.stereotype.Component;

@Component
public class ColleagueMapper {

    public ColleagueEntity toEntity(Colleague colleague){
        return new ColleagueEntity(colleague.id(), colleague.name(), colleague.dni());
    }

    public Colleague toPOJO(ColleagueEntity entity){
        return new Colleague(entity.getColleagueId(), entity.getName(), entity.getDni());
    }

    public Colleague toPOJO(ColleagueRequest request){
        return new Colleague(null, request.name(), request.dni());
    }

    public ColleagueResponse toResponse(Colleague colleague){
        return new ColleagueResponse(colleague.id(), colleague.name(), colleague.dni());
    }
}
