package com.linkey.core.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorResult {
    private int status;
    private int errorCode;
    private String message;
}
