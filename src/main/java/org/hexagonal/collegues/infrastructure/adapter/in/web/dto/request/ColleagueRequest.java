package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.custombean.Dni;

public record ColleagueRequest(
        @NotBlank
        String name,

        @Dni
        String dni
) {
}
