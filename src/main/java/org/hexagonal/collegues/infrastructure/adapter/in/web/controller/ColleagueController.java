package org.hexagonal.collegues.infrastructure.adapter.in.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hexagonal.collegues.application.usecase.DeleteColleagueUseCase;
import org.hexagonal.collegues.application.usecase.GetColleagueUseCase;
import org.hexagonal.collegues.application.usecase.UpdateColleagueUseCase;
import org.hexagonal.collegues.domain.ports.in.CreateColleagueUseCase;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.custombean.Dni;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request.ColleagueRequest;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.ApiError;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.ColleagueResponse;
import org.hexagonal.collegues.infrastructure.adapter.out.persistence.mapper.ColleagueMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.cfg.MapperBuilder;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/colleagues")
public class ColleagueController {

    private final GetColleagueUseCase getColleagueUseCase;
    private final CreateColleagueUseCase createColleagueUseCase;
    private final DeleteColleagueUseCase deleteColleagueUseCase;
    private final UpdateColleagueUseCase updateColleagueUseCase;
    private final ColleagueMapper colleagueMapper;
    private final MapperBuilder mapperBuilder;

    @PostMapping
    public ResponseEntity<ColleagueResponse> createColleagues(@Valid @RequestBody ColleagueRequest request){
        return ResponseEntity.ok(
                colleagueMapper.toResponse(createColleagueUseCase.createColleague(colleagueMapper.toPOJO(request)))
        );
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ColleagueResponse> getByDNI(@Valid @PathVariable @Dni String dni){
        return ResponseEntity.ok(
                colleagueMapper.toResponse(getColleagueUseCase.getColleagueByDni(dni))
        );
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> deleteByDNI(@Valid @PathVariable @Dni String dni){
        deleteColleagueUseCase.deleteColleagueByDni(dni);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{dni}")
    public ResponseEntity<ColleagueResponse> updateByDNI(@Valid @PathVariable @Dni String dni, @Valid @RequestBody ColleagueRequest request){
        return ResponseEntity.ok(colleagueMapper.toResponse(updateColleagueUseCase.updateColleague(colleagueMapper.toPOJO(request), dni)));
    }
}
