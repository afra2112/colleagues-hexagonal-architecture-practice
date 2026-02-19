package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response;

import org.hexagonal.collegues.domain.exception.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.List;

public record ApiError(
        ErrorCodeEnum codeEnum,
        String internalCode,
        String message,
        int statusNumber,
        LocalDateTime timestamp,
        String path,
        List<FieldError> errors
) {
}
