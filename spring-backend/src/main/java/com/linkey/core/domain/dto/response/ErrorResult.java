package com.linkey.core.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResult {
    private String status;
    private int errorCode;
    private String message;
}