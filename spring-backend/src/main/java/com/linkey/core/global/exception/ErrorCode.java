package com.linkey.core.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 1000번대: 사용자 관련 예외 처리
    USER_NOT_FOUND(1001, "해당 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),


    // ----


    // 2000번대: 팀 관련 예외 처리
    TEAM_NOT_FOUND(2001, "해당 팀을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_TEAM_MEMBER(2002, "이미 존재하는 팀원입니다.", HttpStatus.BAD_REQUEST),
    TEAM_MEMBER_NOT_FOUND(2003, "해당 팀원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),

    // ----


    // 3000~3099 : Project DQL 관련 예외
    PROJECT_NOT_FOUND(3001, "해당하는 프로젝트를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 3100~3399 : Project DML 관련 예외처리
    CAN_NOT_FIND_PROJECT(3101, "프로젝트를 검색할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_CREATE_PROJECT(3102, "프로젝트를 생성할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_UPDATE_PROJECT(3103, "프로젝트를 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_DELETE_PROJECT(3104, "프로젝트를 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    // 3400~3999 : Project 기타 예외처리
    // 공통 예외처리
    INVALID_INPUT_VALUE(3401, "입력 값이 유효하지 않습니다.", HttpStatus.BAD_REQUEST),


    // ----


    // 4000~4099 : Sprint DQL 관련 예외
    SPRINT_NOT_FOUND(4001, "해당하는 스프린트를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 4100~4399 : Sprint DML 관련 예외처리
    CAN_NOT_FIND_SPRINT(4101, "스프린트를 검색할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_CREATE_SPRINT(4102, "스프린트를 생성할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_UPDATE_SPRINT(4103, "스프린트를 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_DELETE_SPRINT(4104, "스프린트를 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    // 4400~4999 : Sprint 기타 예외처리
    SPRINT_END_DATE_IS_INVALID(4401, "스프린트 종료 날짜는 시작날짜보다 앞설 수 없습니다.", HttpStatus.NOT_ACCEPTABLE),


    // ----


    // 5000번대: Todo 관련 예외처리
    TODO_NOT_FOUND(5001, "해당 Todo를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    TODO_CREATE_FAIL(5002, "Todo 생성에 실패했습니다.", HttpStatus.BAD_REQUEST),
    TODO_UPDATE_FAIL(5003, "Todo 수정에 실패했습니다.", HttpStatus.BAD_REQUEST),
    TODO_DELETE_FAIL(5004, "Todo 삭제에 실패했습니다.", HttpStatus.BAD_REQUEST),
    TODO_INVALID_USER(5005, "존재하지 않는 사용자입니다.", HttpStatus.BAD_REQUEST),
    TODO_INVALID_SPRINT(5006, "존재하지 않는 스프린트입니다.", HttpStatus.BAD_REQUEST),


    // ----


    // 6000~6099 : Image DQL 관련 예외
    IMAGE_NOT_FOUND(6001, "해당하는 이미지를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 6100~6399 : Image DML 관련 예외처리
    CAN_NOT_FIND_IMAGE(6101, "이미지를 검색할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_CREATE_IMAGE(6102, "이미지를 생성할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_UPDATE_IMAGE(6103, "이미지를 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),
    CAN_NOT_DELETE_IMAGE(6104, "이미지를 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),
    UPDATE_PARAMETER_IS_EMPTY(6105, "이미지 업데이트에 필요한 인자가 없습니다.", HttpStatus.BAD_REQUEST),

    // 6400~6999 : Image 기타 예외처리
    UPLOAD_DIR_NOT_EXIST(6401, "해당 경로가 유효하지 않습니다.", HttpStatus.NOT_ACCEPTABLE),
    CAN_NOT_WRITE(6402, "파일 쓰기가 실패했습니다.", HttpStatus.NOT_ACCEPTABLE),
    IMAGE_FILE_CAN_NOT_NULL(6403, "이미지 파일을 제공해주세요", HttpStatus.NOT_ACCEPTABLE),


    // ----


    // 9000~9999 : 기타
    NOT_VALID_ARGUMENT(9001, "입력 값이 유효하지 않습니다.", HttpStatus.BAD_REQUEST)

    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

}
