package com.vishnu.cloudnine.util;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    FORM_DUPLICATION(HttpStatus.BAD_REQUEST),
    INVALID_USER_REQUEST(HttpStatus.BAD_REQUEST),
    UNEXPECTED_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);
    private final HttpStatus status;

    ErrorCode(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return this.status;
    }

    public String getCodeName() {
        return name();
    }
}
