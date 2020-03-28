package com.rainsunset.common.bean;

import java.io.Serializable;

/**
 * @param <T> the type parameter
 * @description: API标准返回对象
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.04
 * @version : 1.0
 */
public class ResponseResult<T> implements Serializable {

    /**
     * 业务成功/失败
     */
    private boolean success;

    /**
     * 业务返回对象
     */
    private T data;

    /**
     * message
     */
    private String message;

    /**
     * 错误码
     */
    private String errorCode;

    public ResponseResult() {}

    public ResponseResult(boolean success, T data, String message, String errorCode) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.errorCode = errorCode;
    }

    /**
     * Is success boolean.
     *
     * @return the boolean
     * @author : ligangwei / 2019-09-24
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     * @author : ligangwei / 2019-09-24
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Get message string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @author : ligangwei / 2019-09-24
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get data t.
     *
     * @return the t
     * @author : ligangwei / 2019-09-24
     */
    public T getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     * @author : ligangwei / 2019-09-24
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get errorcode string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets errorcode.
     *
     * @param errorcode the errorcode
     * @author : ligangwei / 2019-09-24
     */
    public void setErrorCode(String errorcode) {
        this.errorCode = errorcode;
    }
}
