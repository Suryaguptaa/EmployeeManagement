package com.emapp.EmployeeManagement.common.error;
import java.time.LocalDateTime;
import java.util.*;


//this file is shows how the error should look like
public class ApiErrorResponse {

    private final String errorCode;
    private final String message;
    private final List<String> details;

    public ApiErrorResponse(String errorCode, String message, List<String> details){
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    private final LocalDateTime timestamp;
}
