package com.moadeal.moadeal.global.payload.status;

import com.moadeal.moadeal.global.payload.BaseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SusccessStatus implements BaseCode {

    OK(HttpStatus.OK.value(), "S000", "요청이 성공적으로 수행되었습니다.");

    private final int status;
    private final String code;
    private final String message;

    SusccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
