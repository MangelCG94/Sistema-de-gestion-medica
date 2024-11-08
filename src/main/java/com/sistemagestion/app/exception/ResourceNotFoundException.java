package com.sistemagestion.app.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final int errorCode;

    public ResourceNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
