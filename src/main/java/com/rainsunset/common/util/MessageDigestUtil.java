package com.rainsunset.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version : 1.0
 * @description: MessageDigest加密工具
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019 -10-10
 */
public class MessageDigestUtil {

    private static Logger logger = LoggerFactory.getLogger(MessageDigestUtil.class);

    /** algorithm - MD5 */
    private static String MD5 = "MD5";

    /** algorithm - SHA1 */
    private static String SHA1 = "SHA1";

    /** algorithm - SHA-224 */
    private static String SHA224 = "SHA-224";

    /** algorithm - SHA256 */
    private static String SHA256 = "SHA-256";

    /** algorithm - SHA384 */
    private static String SHA384 = "SHA-384";

    /** algorithm - SHA512 */
    private static String SHA512 = "SHA-512";

    /**
     * Get md 5 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 5:57:15
     */
    public static String getMd5(String str) {
        return getEncryption(str, MD5);
    }

    /**
     * Get sha 1 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 6:08:15
     */
    public static String getSHA1(String str) {
        return getEncryption(str, SHA1);
    }

    /**
     * Get sha 224 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 6:08:15
     */
    public static String getSHA224(String str) {
        return getEncryption(str, SHA224);
    }

    /**
     * Get sha 256 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 5:57:15
     */
    public static String getSHA256(String str) {
        return getEncryption(str, SHA256);
    }

    /**
     * Get sha 384 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 6:08:15
     */
    public static String getSHA384(String str) {
        return getEncryption(str, SHA384);
    }

    /**
     * Get sha 512 string.
     *
     * @param str the str
     * @return the string
     * @author : ligangwei / 2019-10-10 5:57:15
     */
    public static String getSHA512(String str) {
        return getEncryption(str, SHA512);
    }

    /**
     * Get encryption string.
     *
     * @param str       the str
     * @param algorithm the algorithm
     * @return the string
     * @author : ligangwei / 2019-10-10 5:57:15
     */
    private static String getEncryption(String str,String algorithm){
        if (null == str) {
            return null;
        }
        String encodestr = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("不支持的加密算法！");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            logger.error("不支持的编码！");
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * Byte 2 hex string.
     *
     * @param bytes the bytes
     * @return the string
     * @author : ligangwei / 2019-10-10 5:57:16
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<bytes.length;i++){
            String temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                // 得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
