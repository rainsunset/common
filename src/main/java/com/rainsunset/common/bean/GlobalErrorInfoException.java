package com.rainsunset.common.bean;

/**
 * @Description: 全局异常封装类
 * @Author: ligw
 * @Company rainsunset
 * @CreateDate: 2019.04.04
 * @Version : 1.0
 */
public class GlobalErrorInfoException extends RuntimeException {

    /**
     * Error info
     */
    private ErrorInfoInterface errorInfo;

    /**
     * Global error info exception.
     *
     * @param errorInfo the error info
     */
    public GlobalErrorInfoException(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    /**
     * Get error info error info interface.
     *
     * @return the error info interface
     * @author : ligangwei / 2019-09-24
     */
    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets error info.
     *
     * @param errorInfo the error info
     * @author : ligangwei / 2019-09-24
     */
    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
