/*
 * Copyright (c) 2022-2023.  Katarzyna Fidos
 * All rights reserved.
 */

package com.vishnu.cloudnine.util;

/*
 * @created 09/03/2023
 * @project lecture-demo
 * @author Katarzyna Fidos
 */
public class CorporateFormServiceException extends RuntimeException {
    ErrorCode errorCode;
    public CorporateFormServiceException(String message, ErrorCode errorCode) {
        this(message, errorCode, null);
    }
    public CorporateFormServiceException(final String message, ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
