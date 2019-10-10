package com.rainsunset.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @version : 1.0
 * @description: Base64转换工具
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019 -10-10
 */
public class Base64Util {

    private static Logger log = LoggerFactory.getLogger(Base64Util.class);

    /**
     * Base64 解码
     *
     * @param key the key
     * @return the string
     * @throws Exception the exception
     * @author : ligangwei / 2019-10-10 10:25:00
     */
    public static String decode(String key) {
        try {
            byte[] bytes = (new BASE64Decoder()).decodeBuffer(key);
        } catch (IOException e) {
            log.error("Base64DecodeError");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Base64 编码
     *
     * @param key the key
     * @return string string
     * @throws Exception the exception
     * @author : ligangwei / 2019-10-10 10:25:00
     */
    public static String encode(String key) {
        try {
            byte[] bytes = key.getBytes("UTF-8");
            return (new BASE64Encoder()).encodeBuffer(bytes);
        } catch (UnsupportedEncodingException e) {
            log.error("Base64EncodeError");
            e.printStackTrace();
        }
        return null;
    }
}
