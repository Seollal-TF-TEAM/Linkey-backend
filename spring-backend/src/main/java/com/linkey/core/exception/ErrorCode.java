package com.linkey.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // 1000번대: 사용자 관련 예외 처리
    USER_NOT_FOUND(1001, "해당 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 2000번대: 팀 관련 예외 처리
    TEAM_NOT_FOUND(2001, "해당 팀을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_TEAM_MEMBER(2002, "이미 존재하는 팀원입니다.", HttpStatus.BAD_REQUEST);

    // 3000번대 : 프로젝트 관련 예외처리


    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
