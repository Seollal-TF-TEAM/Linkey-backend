package com.linkey.core.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class ErrorResult {
    private int status;
    private int errorCode;
    private String message;
}
