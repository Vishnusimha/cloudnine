package com.vishnu.cloudnine.util;

public class PersonalEventFormServiceException extends RuntimeException {
    ErrorCode errorCode;

    public PersonalEventFormServiceException(String message, ErrorCode errorCode) {
        this(message, errorCode, null);
    }

    public PersonalEventFormServiceException(final String message, ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
