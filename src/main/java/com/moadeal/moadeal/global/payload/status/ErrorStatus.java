package com.moadeal.moadeal.global.payload.status;

import com.moadeal.moadeal.global.payload.BaseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorStatus implements BaseCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "E000", "잘못된 요청입니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
