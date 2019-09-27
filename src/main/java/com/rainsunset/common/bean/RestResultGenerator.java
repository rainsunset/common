package com.rainsunset.common.bean;

/**
 * @description: 构造Response工具类
 * @author: ligangwei
 * @company rainsunsetr
 * @date: 2019.04.04
 * @version : 1.0
 */
public class RestResultGenerator {

    /**
     * Gen result response result.
     *
     * @param <T>  the type parameter
     * @param data the data
     * @return the response result
     * @author : ligangwei / 2019-09-24
     */
    public static <T> ResponseResult<T> genResult(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    /**
     * Gen result response result.
     *
     * @param <T>       the type parameter
     * @param errorInfo the error info
     * @return the response result
     * @author : ligangwei / 2019-09-24
     */
    public static <T> ResponseResult<T> genResult(ErrorInfoInterface errorInfo) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setErrorCode(errorInfo.getCode());
        result.setMessage(errorInfo.getMessage());
        return result;
    }

    /**
     * Gen error result response result.
     *
     * @param <T> the type parameter
     * @param msg the msg
     * @return the response result
     * @author : ligangwei / 2019-09-24
     */
    public static <T> ResponseResult<T> genErrorResult(String msg) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setMessage(msg);
        return result;
    }

    /**
     * Gen error result response result.
     *
     * @param <T>  the type parameter
     * @param data the data
     * @return the response result
     * @author : ligangwei / 2019-09-24
     */
    public static <T> ResponseResult<T> genErrorResult(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setData(data);
        return result;
    }
}
