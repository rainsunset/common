package com.rainsunset.common.bean;

/**
 * @Description: 全局异常封装类
 * @Author: ligw
 * @Company rainsunset
 * @CreateDate: 2019.04.04
 * @Version : 1.0
 */
public class GlobalErrorInfoException extends RuntimeException {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
