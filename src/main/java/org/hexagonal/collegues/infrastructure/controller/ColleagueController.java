package org.hexagonal.collegues.infrastructure.controller;

import org.hexagonal.collegues.domain.model.Colleague;
import org.hexagonal.collegues.domain.service.ColleagueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/colleagues")
public class ColleagueController {

    private final ColleagueService colleagueService;

    public ColleagueController(ColleagueService colleagueService){
        this.colleagueService = colleagueService;
    }

    @PostMapping
    public ResponseEntity<Colleague> createColleagues(@RequestBody Colleague colleague){
        return ResponseEntity.ok(colleagueService.createColleague(colleague));
    }
}
