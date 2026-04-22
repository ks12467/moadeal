package com.moadeal.moadeal.global.payload;

import com.moadeal.moadeal.global.payload.status.SusccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    private final boolean success;
    private final T data;
    private final String code;
    private final String message;
    private final int status;

    public static <T> BaseResponse<T> success(BaseCode code, T data) {
        return new BaseResponse<>(
                true,
                data,
                code.getCode(),
                code.getMessage(),
                code.getStatus()
        );
    }

    public static<T> BaseResponse<T> fail(BaseCode code) {
        return new BaseResponse<>(
                false,
                null,
                code.getCode(),
                code.getMessage(),
                code.getStatus()
        );
    }
}
