package com.rainsunset.common.bean;

/**
 * @Description: 构造Response工具类
 * @Author: ligw
 * @Company rainsunsetr
 * @CreateDate: 2019.04.04
 * @Version : 1.0
 */
public class RestResultGenerator {

    public static <T> ResponseResult<T> genResult(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setData(data);
        result.setSuccess(true);
        result.setMessage(GlobalErrorInfoEnum.SUCCESS.getMessage());
        return result;
    }

    public static <T> ResponseResult<T> genResult(ErrorInfoInterface errorInfo) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setErrorcode(errorInfo.getCode());
        result.setMessage(errorInfo.getMessage());
        return result;
    }

    public static <T> ResponseResult<T> genErrorResult(String msg) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResponseResult<T> genErrorResult(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setData(data);
        return result;
    }
}
