package org.hexagonal.collegues.domain.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCodeEnum errorCodeEnum;

    public BusinessException(ErrorCodeEnum code) {
        super(code.getMessage());
        this.errorCodeEnum = code;
    }

    public BusinessException(ErrorCodeEnum code, String customMessage) {
        super(customMessage);
        this.errorCodeEnum = code;
    }
}
