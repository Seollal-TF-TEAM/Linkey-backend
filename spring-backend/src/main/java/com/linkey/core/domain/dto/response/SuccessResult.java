package com.linkey.core.domain.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class SuccessResult {
    private String status;
    private Object data;
}
