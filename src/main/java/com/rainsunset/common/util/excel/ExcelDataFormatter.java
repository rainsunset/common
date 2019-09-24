package com.rainsunset.common.util.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Excel数据导入导出格式化<br>  举例:<br> 数据导出， {lock,{0:正常，1:锁定}}<br> 数据导入,{lock,{正常:0，锁定:1}}
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.09
 * @version : 1.0
 */
public class ExcelDataFormatter {

    /**
     * Formatter
     */
    private Map<String, Map<String, String>> formatter = new HashMap<String, Map<String, String>>();

    /**
     * Set.
     *
     * @param key the key
     * @param map the map
     * @author : ligangwei / 2019-09-24
     */
    public void set(String key, Map<String, String> map) {
        formatter.put(key, map);
    }

    /**
     * Get map.
     *
     * @param key the key
     * @return the map
     * @author : ligangwei / 2019-09-24
     */
    public Map<String, String> get(String key) {
        return formatter.get(key);
    }

}