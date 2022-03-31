package com.hundun.demo.service.exception;

public enum ReturnCode {

    /* 成功 */
    SUCCESS("200", "success","Successful."),
    INVALID_INPUT("525", "invalid_input_data", "Invalid Input data."),
    UNKNOWN_EXCEPTION("550", "unknown_exception", "Unknown Exception. Please contact the administrator.")
    ;

    final static String PRE_FIX = "return.message.";

    /**
     * code
     */
    private String code;

    /**
     * message key, support i18n.
     */
    private String message;

    /**
     * default message.
     */
    private String defaultMessage;

    ReturnCode(String code, String message, String defaultMessage) {
        this.code = code;
        this.message = message;
        this.defaultMessage = defaultMessage;
    }

}
