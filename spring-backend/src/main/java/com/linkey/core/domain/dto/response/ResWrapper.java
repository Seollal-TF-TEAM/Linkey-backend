package com.linkey.core.domain.dto.response;

import com.linkey.core.global.exception.CustomException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResWrapper<T> {
    private T result;

    public static ResWrapper<SuccessResult> resSuccess(Object o) {

        return ResWrapper.<SuccessResult>builder()
                .result(SuccessResult.builder()
                        .status(200)
                        .data(o)
                        .build()
                ).build();
    }
    public static ResWrapper<ErrorResult> resException(Exception e) {

        return ResWrapper.<ErrorResult>builder()
                .result(ErrorResult.builder()
                        .status(499)
                        .errorCode(9999)
                        .message(e.getMessage())
                        .build()
                ).build();
    }

    public static ResWrapper<ErrorResult> resCustomException(CustomException e) {

        return ResWrapper.<ErrorResult>builder()
                .result(ErrorResult.builder()
                        .status(e.getErrorCode().getHttpStatus().value())
                        .errorCode(e.getErrorCode().getCode())
                        .message(e.getErrorCode().getMessage())
                        .build()
                ).build();
    }
}





