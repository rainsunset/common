package com.rainsunset.common.bean;

/**
 * @description: 全局异常枚举类
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.04
 * @version : 1.0
 */
public enum GlobalErrorInfoEnum implements ErrorInfoInterface {

    /**
     * 200，成功
     * 201，已存在
     * 401，未授权
     * 403，禁止
     * 404，不存在
     * 405，状态异常
     * 412，前提条件失败
     * 415，格式错
     * 500，内部错误
     */

    SUCCESS("0", "success"),

    /**
     * System error global error info enum.
     */
    SYSTEM_ERROR("-1", "系统异常"),

    ;

    /**
     * Code
     */
    private String code;

    /**
     * Message
     */
    private String message;

    /**
     * Global error info enum.
     *
     * @param code    the code
     * @param message the message
     */
    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Get msg by code string.
     *
     * @param code the code
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    public static String getMsgByCode(String code) {
        for (GlobalErrorInfoEnum responseInfo : GlobalErrorInfoEnum.values()) {
            if (code.equals(responseInfo.getCode())) {
                return responseInfo.getMessage();
            }
        }
        return code + "未定义";
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
