package com.rainsunset.common.bean;

/**
 * @description: 全局异常封装类
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.04
 * @version : 1.0
 */
public class GlobalErrorInfoException extends RuntimeException {

    /**
     * Error info
     */
    private final String code;

    /**
     * Global error info exception.
     *
     * @param errorInfo the error info
     */
    public GlobalErrorInfoException(ErrorInfoInterface errorInfo) {
        super(errorInfo.getMessage());
        this.code = errorInfo.getCode();
    }

    /**
     * Global error info exception.
     *
     * @param errorInfo the error info
     * @param message   the message
     */
    public GlobalErrorInfoException(ErrorInfoInterface errorInfo,String message) {
        super(message);
        this.code = errorInfo.getCode();
    }

    /**
     * Get error info error info interface.
     *
     * @return the error info interface
     * @author : ligangwei / 2019-09-24
     */
    public String getCode() {
        return code;
    }

}
