/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.rainsunset.common.bean;

import java.io.Serializable;

/**
 * @param <T> the type parameter
 * @Description: API标准返回对象
 * @Author: ligw
 * @Company rainsunset
 * @CreateDate: 2019.04.04
 * @Version : 1.0
 */
public class ResponseResult<T> implements Serializable {

    /**
     * 业务成功/失败
     */
    private boolean success;

    /**
     * message
     */
    private String message;

    /**
     * 业务返回对象
     */
    private T data;

    /**
     * 错误码
     */
    private String errorcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}
