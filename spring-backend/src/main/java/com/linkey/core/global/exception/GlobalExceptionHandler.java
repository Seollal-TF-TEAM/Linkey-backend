package com.linkey.core.global.exception;

import com.linkey.core.domain.dto.response.ErrorResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResult> handleCustomException(CustomException e) {
        ErrorCode code = e.getErrorCode();

        ErrorResult error = new ErrorResult(
                code.getHttpStatus().value(),
                code.getCode(),
                code.getMessage()
        );

        return ResponseEntity.status(code.getHttpStatus()).body(error);
    }


}
