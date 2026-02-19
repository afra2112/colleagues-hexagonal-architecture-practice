package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response;

public record ColleagueResponse(
        Long id,
        String name,
        String dni
) {
}
