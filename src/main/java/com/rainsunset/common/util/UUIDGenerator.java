package com.rainsunset.common.util;

import java.util.UUID;

/**
 * @description: TODO
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.05.29
 * @version : 1.0
 */
public class UUIDGenerator {

    /**
     * 获取去-的UUID
     *
     * @return the string
     * @author : ligangwei / 2019-05-29
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }

    /**
     * 获得指定数量的UUID
     *
     * @param number the number
     * @return the string [ ]
     * @author : ligangwei / 2019-05-29
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
