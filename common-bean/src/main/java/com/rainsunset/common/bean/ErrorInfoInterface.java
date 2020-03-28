/**
 * company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.rainsunset.common.bean;

/**
 * @description: 异常枚举类通用接口
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019 /4/4 16:53
 * @version : 1.0
 */
public interface ErrorInfoInterface {

    /**
     * Get code string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    String getCode();

    /**
     * Get message string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    String getMessage();

}
