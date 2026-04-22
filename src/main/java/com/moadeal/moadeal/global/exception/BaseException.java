package com.moadeal.moadeal.global.exception;

import com.moadeal.moadeal.global.payload.status.ErrorStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final ErrorStatus errorStatus;

    public BaseException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
