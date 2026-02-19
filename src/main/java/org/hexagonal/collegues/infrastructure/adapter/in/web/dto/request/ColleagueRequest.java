package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ColleagueRequest(
        @NotBlank
        String name,

        @NotBlank
        @Pattern(regexp = "^DNI-\\d{1,10}$", message = "Dni must be like: \"DNI-1234567890\"")
        String dni
) {
}
