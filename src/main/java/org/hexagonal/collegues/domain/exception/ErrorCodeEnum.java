package org.hexagonal.collegues.domain.exception;


public enum ErrorCodeEnum {

    USER_ALREADY_EXISTS("ERR-001", 409, "Colleague already exists with that dni."),
    SPRING_VALIDATION("ERR-002", 400, "Spring validation errors: "),
    ENTITY_NOT_FOUND("ERR-003", 404, "Entity was not found");

    private final String code;
    private final int status;
    private final String message;

    ErrorCodeEnum(String code, int status, String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus(){
        return status;
    }

    public String getMessage() {
        return message;
    }
}
