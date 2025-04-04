package com.linkey.core.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
public class ResCommitDto {
    private String message;  // 커밋 메시지
    private String author;   // 작성자 이름
}
