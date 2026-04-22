package com.moadeal.moadeal.global.exception;

import com.moadeal.moadeal.global.payload.BaseResponse;
import com.moadeal.moadeal.global.payload.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<Void>> handleCustomException(BaseException e) {
        return handleExceptionInternal(e.getErrorStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Void>> handleValidException(MethodArgumentNotValidException e) {
        log.warn("ValidationException: {}", e.getMessage());
        return handleExceptionInternal(ErrorStatus.VALIDATION_FAIL);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Void>> handleException(Exception e) {
        log.error("UnExcepted Exception: ", e);
        return handleExceptionInternal(ErrorStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<BaseResponse<Void>> handleExceptionInternal(ErrorStatus errorStatus) {
        return ResponseEntity.status(errorStatus.getStatus()).body(BaseResponse.fail(errorStatus));
    }
}
