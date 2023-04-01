package com.vishnu.cloudnine.util;

public class CorporateEventFormServiceException extends RuntimeException {
    ErrorCode errorCode;

    public CorporateEventFormServiceException(String message, ErrorCode errorCode) {
        this(message, errorCode, null);
    }

    public CorporateEventFormServiceException(final String message, ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
