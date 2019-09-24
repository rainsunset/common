package com.rainsunset.common.util;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Description: SHA1 安全加密算法
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.05.29
 * @Version : 1.0
 */
public class Sha1 {

    /**
     * SHA1 安全加密算法
     *
     * @param maps 参数key-value map集合
     * @return string string
     * @throws DigestException the digest exception
     * @author : ligangwei / 2019-05-29
     */
    public static String SHA1(Map<String, Object> maps) throws DigestException {
        //获取信息摘要 - 参数字典排序后字符串  
        String decrypt = getOrderByLexicographic(maps);
        //System.out.println("decrypt->>>>>"+decrypt);
        try {
            //指定sha1算法  
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decrypt.getBytes());
            //获取字节数组  
            byte messageDigest[] = digest.digest();
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString().toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new DigestException("签名错误！");
        }
    }

    /**
     * SHA1 安全加密算法
     *
     * @param decrypt the decrypt
     * @return string string
     * @throws DigestException the digest exception
     * @author : ligangwei / 2019-05-29
     */
    public static String SHA1(String decrypt) throws DigestException {
        //获取信息摘要 - 参数字典排序后字符串  
        // String decrypt = getOrderByLexicographic(maps);
        //System.out.println("decrypt->>>>>"+decrypt);
        try {
            //指定sha1算法  
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decrypt.getBytes());
            //获取字节数组  
            byte messageDigest[] = digest.digest();
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new DigestException("签名错误！");
        }
    }

    /**
     * 获取参数的字典排序
     *
     * @param maps 参数key-value map集合
     * @return String 排序后的字符串
     * @author : ligangwei / 2019-05-29
     */
    private static String getOrderByLexicographic(Map<String, Object> maps) {
        return splitParams(lexicographicOrder(getParamsName(maps)), maps);
    }

    /**
     * 获取参数名称 key
     *
     * @param maps 参数key-value map集合
     * @return list list
     * @author : ligangwei / 2019-05-29
     */
    private static List<String> getParamsName(Map<String, Object> maps) {
        List<String> paramNames = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : maps.entrySet()) {
            paramNames.add(entry.getKey());
        }
        return paramNames;
    }

    /**
     * 参数名称按字典排序
     *
     * @param paramNames 参数名称List集合
     * @return 排序后的参数名称List集合 list
     * @author : ligangwei / 2019-05-29
     */
    private static List<String> lexicographicOrder(List<String> paramNames) {
        Collections.sort(paramNames);
        return paramNames;
    }

    /**
     * 拼接排序好的参数名称和参数值
     *
     * @param paramNames 排序后的参数名称集合
     * @param maps       参数key-value map集合
     * @return String 拼接后的字符串
     * @author : ligangwei / 2019-05-29
     */
    private static String splitParams(List<String> paramNames, Map<String, Object> maps) {
        StringBuilder paramStr = new StringBuilder();
        for (String paramName : paramNames) {
            paramStr.append("&");
            paramStr.append(paramName);
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                if (paramName.equals(entry.getKey())) {
                    paramStr.append("=");
                    paramStr.append(String.valueOf(entry.getValue()));
                }
            }
        }


        return paramStr.toString().substring(1);
    }

}