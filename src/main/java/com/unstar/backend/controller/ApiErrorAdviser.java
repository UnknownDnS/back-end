package com.unstar.backend.controller;

import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.exception.ForbiddenException;
import com.unstar.backend.exception.InvalidUserNameException;
import com.unstar.backend.exception.UnAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 예외 처리 클래스
 */
@RestControllerAdvice
public class ApiErrorAdviser {

    @ExceptionHandler(InvalidUserNameException.class)
    public RootResponseDTO<Object> invalidUserNameException(InvalidUserNameException e) {
        return new RootResponseDTO<>()
                .code(HttpStatus.BAD_REQUEST.value())
                .errorMsg(e.getMessage())
                .build();
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public RootResponseDTO<Object> unAuthorizedException(UnAuthorizedException e) {
        return new RootResponseDTO<>()
                .code(HttpStatus.UNAUTHORIZED.value())
                .errorMsg(e.getMessage())
                .build();
    }

    @ExceptionHandler(ForbiddenException.class)
    public RootResponseDTO<Object> forbiddenException(ForbiddenException e) {
        return new RootResponseDTO<>()
                .code(HttpStatus.FORBIDDEN.value())
                .errorMsg(e.getMessage())
                .build();
    }
}
