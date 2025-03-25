package com.linkey.core.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResWrapper<T> {
    private T result;
}




