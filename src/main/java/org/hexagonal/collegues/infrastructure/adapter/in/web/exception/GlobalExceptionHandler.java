package org.hexagonal.collegues.infrastructure.adapter.in.web.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.ApiError;
import org.hexagonal.collegues.domain.exception.BusinessException;
import org.hexagonal.collegues.domain.exception.ErrorCodeEnum;
import org.hexagonal.collegues.infrastructure.adapter.in.web.dto.response.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ApiError buildApiError(ErrorCodeEnum code, HttpServletRequest request, List<FieldError> errors){
        return new ApiError(
                code,
                code.getCode(),
                code.getMessage(),
                code.getStatus(),
                LocalDateTime.now(),
                request.getRequestURI(),
                errors
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException ex, HttpServletRequest request){
        return ResponseEntity
                .status(ex.getErrorCodeEnum().getStatus())
                .body(buildApiError(
                        ex.getErrorCodeEnum(),
                        request,
                        null
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleSpringValidationException(MethodArgumentNotValidException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(buildApiError(
                        ErrorCodeEnum.SPRING_VALIDATION,
                        request,
                        ex.getBindingResult().getFieldErrors()
                                .stream()
                                .map(error -> new FieldError(error.getField(), error.getDefaultMessage()))
                                .toList()
                ));
    }
}
