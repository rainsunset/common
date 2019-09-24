package com.rainsunset.common.bean;

import java.io.Serializable;

/**
 * @Description: 基础请求参数
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.09.24
 * @Version : 1.0
 */
public class BaseRequest implements Serializable {
    /**
     * 日志id
     */
    private String traceLogId;

    /**
     * Get trace log id string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
    public String getTraceLogId() {
        return traceLogId;
    }

    /**
     * Sets trace log id.
     *
     * @param traceLogId the trace log id
     * @author : ligangwei / 2019-09-24
     */
    public void setTraceLogId(String traceLogId) {
        this.traceLogId = traceLogId;
    }
}
