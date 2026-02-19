package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.custombean.Dni;

public record ColleagueRequest(
        @NotBlank
        String name,

        @Dni
        String dni
) {
}
