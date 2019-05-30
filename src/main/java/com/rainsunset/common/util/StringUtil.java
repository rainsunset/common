package com.rainsunset.common.util;

import org.springframework.util.StringUtils;

/**
 * @Description: 字符串到基础对象的严格转化  应对与php对接字符问题
 * @Author: 李刚伟
 * @Company rainsunset
 * @CreateDate: 2019 /4/19 0:49
 * @Version : 1.0
 * @ClassName StringUtil
 */
public class StringUtil {

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
			res = Integer.parseInt(str);
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
			res = Long.parseLong(str);
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
			res = str.equals("true") ? true : (str.equals("false") ? false : null);
		} catch (Exception e) {
			return null;
		}
		return res;
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

}
