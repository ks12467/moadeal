package com.moadeal.moadeal.global.payload.status;

import com.moadeal.moadeal.global.payload.BaseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorStatus implements BaseCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "E000", "잘못된 요청입니다."),
    VALIDATION_FAIL(HttpStatus.BAD_REQUEST.value(), "E001", "검증에 실패하였습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "E002", "서버 오류가 발생했습니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
