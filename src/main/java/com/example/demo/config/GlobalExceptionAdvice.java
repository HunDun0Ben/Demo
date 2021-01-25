package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 校验失败进入统一的异常处理器，告知前端校验失败。
     * 并且打印出错的字段，及对应的value
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException ex) {
        HttpHeaders headers = new HttpHeaders();
        log.error("日志异常", ex);
        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : bindingResult) {
            Object value = fieldError.getRejectedValue();
            String valueStr = null;

            log.error("Validate error message: {} ;Field: {}; RejectedValue: {}", fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getRejectedValue());
        }
        return new ResponseEntity<String>("bad request", headers, HttpStatus.BAD_REQUEST);
    }

    private String getRejectValueString(Object obj) {

        return null;
    }
}
