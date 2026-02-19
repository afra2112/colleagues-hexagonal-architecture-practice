package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response;

public record FieldError(
        String field,
        String error
) {
}
