package com.hundun.demo.exception;


import org.slf4j.helpers.MessageFormatter;

public class BusinessException extends RuntimeException {

    /** 异常代码 */
    private final ReturnCode errorCode;
    /** 支持占位符 */
    private final String message;
    /** message 中的占位符参数 */
    private final Object[] args;

    public BusinessException(ReturnCode errorCode, String message, Object ...args) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
        this.args = args;
    }

    public ReturnCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return MessageFormatter.format(message, args).getMessage();
    }

    public Object[] getArgs() {
        return args;
    }
}
