package com.lscavalcante.security.dto;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class ResponseErrorDTO {
    private HttpStatus status;
    private String message;
    private List<Map<String, Object>> errors;

    public ResponseErrorDTO(HttpStatus status, String message, List<Map<String, Object>> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ResponseErrorDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getErrors() {
        return errors;
    }

    public void setErrors(List<Map<String, Object>> errors) {
        this.errors = errors;
    }

}
