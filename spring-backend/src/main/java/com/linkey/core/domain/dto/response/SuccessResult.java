package com.linkey.core.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SuccessResult {
    private String status;
    private ResultData data;

    @Getter
    @Setter
    @AllArgsConstructor
    static class ResultData {
        private int id;
    }
}
