package com.rainsunset.common.util;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.regex.Pattern;

/**
 * @description: 字符串到基础对象的严格转化
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019 /4/19 0:49
 * @version : 1.0
 */
public class StringUtil {
    /** {}关键字替换规则 */
    public static final Pattern PATTERN_BRACE_AROUND_KEYWORD = Pattern.compile("(\\{\\S+?\\})");
    /**
     * 字符转整数
     *
     * @param str the str
     * @return the integer
     * @author : ligangwei / 2019-04-19
     */
    public static Integer str2Integer(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        Integer res = null;
        try {
            BigDecimal bdval = new BigDecimal(str);
            res = bdval.intValue();
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    /**
     * 字符转Long
     *
     * @param str the str
     * @return the long
     * @author : ligangwei / 2019-04-19
     */
    public static Long str2Long(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        Long res = null;
        try {
            BigDecimal bdval = new BigDecimal(str);
            res = bdval.longValue();
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    /**
     * 字符转Boolean
     *
     * @param str the str
     * @return the boolean
     * @author : ligangwei / 2019-04-19
     */
    public static Boolean str2Boolean(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        Boolean res = null;
        try {
            str = str.toLowerCase();
            res = "true".equals(str) ? true : ("false".equals(str) ? false : null);
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    /**
     * str2BigDecimal
     *
     * @param str the str
     * @return big decimal
     * @author : ligangwei / 2019-09-24
     */
    public static BigDecimal str2BigDecimal(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 连接字符串
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return the string
     * @author : ligangwei / 2019-04-11
     */
    public static String conlitionStr(String str1, String... str2) {
        StringBuilder sb = new StringBuilder(str1);
        if (str2.length > 0) {
            for (String str : str2) {
                sb.append(str);
            }
        }
        return sb.toString();
    }


    /**
     * String -> double
     * 直接向下取值,非四舍五入
     *
     * @param str   the str
     * @param scale the scale
     * @return the double
     * @author : ligangwei / 2019-08-14
     */
    public static Double str2Double(String str, Integer scale) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            BigDecimal bdval = new BigDecimal(str);
            double res = bdval.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Encode url with utf 8 string.
     *
     * @param url the url
     * @return the string
     * @author : ligangwei / 2019-06-21
     */
    public static String encodeUrlWithUtf8(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * 非饱和替换
     *
     * @param contentArray the content array
     * @param localTmp     the local tmp
     * @return the string
     * @author : ligangwei / 2019-12-3 22:15:22
     */
    public static String repaceBracesAroundKeyword(String[] contentArray, String localTmp,String defParam) {
        if (null == contentArray || 1 > contentArray.length) {
            return localTmp;
        }
        String[] split = PATTERN_BRACE_AROUND_KEYWORD.split(localTmp);
        int length = split.length;
        // 可能是个纯模板__message__样式
        if (0 == length) {
            return contentArray[0];
        }
        // 检测模板是否是以关键词结尾
        boolean tmpEndWithKey = (!localTmp.endsWith(split[length - 1]));
        // 包含关键词数量必须与传参一致
        int needKeyLength = tmpEndWithKey ? length : (length - 1);
        // 顺序替换
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needKeyLength; i++) {
            sb.append(split[i]);
            if (i < contentArray.length) {
                sb.append(contentArray[i]);
            } else {
                sb.append(defParam);
            }
        }
        if (!tmpEndWithKey) {
            sb.append(split[needKeyLength]);
        }
        return sb.toString();
    }

}
