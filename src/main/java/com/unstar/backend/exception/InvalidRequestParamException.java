package com.unstar.backend.exception;

import lombok.Getter;

@Getter
public class InvalidRequestParamException extends RuntimeException {
    public InvalidRequestParamException(String message) {
        super(message);
    }
}
