package com.vishnu.cloudnine.util;

public class PersonalFormServiceException extends RuntimeException {
    ErrorCode errorCode;
    public PersonalFormServiceException(String message, ErrorCode errorCode) {
        this(message, errorCode, null);
    }
    public PersonalFormServiceException(final String message, ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
