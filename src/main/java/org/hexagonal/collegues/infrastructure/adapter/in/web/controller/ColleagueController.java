package org.hexagonal.collegues.infrastructure.adapter.in.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hexagonal.collegues.domain.ports.in.CreateColleagueUseCase;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request.ColleagueRequest;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.ColleagueResponse;
import org.hexagonal.collegues.infrastructure.adapter.out.persistence.mapper.ColleagueMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/colleagues")
public class ColleagueController {

    private final CreateColleagueUseCase createColleagueUseCase;
    private final ColleagueMapper colleagueMapper;

    @PostMapping
    public ResponseEntity<ColleagueResponse> createColleagues(@RequestBody @Valid ColleagueRequest request){
        return ResponseEntity.ok(
                colleagueMapper.toResponse(createColleagueUseCase.createColleague(colleagueMapper.toPOJO(request)))
        );
    }
}
