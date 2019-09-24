package com.rainsunset.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: MD5加密解密工具类
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.05.29
 * @Version : 1.0
 */
public class MD5Util {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    /**
     * Md 5 string.
     *
     * @param plainText the plain text
     * @return the string
     * @author : ligangwei / 2019-05-29
     */
    public static String md5(String plainText) {

        StringBuffer buf = new StringBuffer("");

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());

            byte b[] = md.digest();

            int num;

            for (int i = 0; i < b.length; i++) {

                num = b[i];

                if (num < 0) {
                    num += 256;
                }
                if (num < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(num));
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("md5", e);
        }

        return buf.toString();
    }
}
