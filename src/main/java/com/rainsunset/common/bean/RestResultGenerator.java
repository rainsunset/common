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
        return new ResponseResult<T>(true, data, "", "");
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
        return new ResponseResult<T>(false, null, errorInfo.getMessage(), errorInfo.getCode());
    }

    /**
     * Gen result response result.
     *
     * @param <T>                the type parameter
     * @param errorInfoException the error info exception
     * @return the response result
     * @author : ligangwei / 2019-9-27 8:43:57
     */
    public static <T> ResponseResult<T> genResult(GlobalErrorInfoException errorInfoException) {
        return new ResponseResult<T>(false, null, errorInfoException.getMessage(), errorInfoException.getCode());
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
        return new ResponseResult<T>(false, null, "", msg);
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
        return new ResponseResult<T>(false, data, "", "");
    }
}
