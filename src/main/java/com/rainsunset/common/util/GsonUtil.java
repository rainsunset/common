package com.rainsunset.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 *
 * @Description:  Java Object <==> Gson String
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.05.29
 * @Version : 1.0
 */
public class GsonUtil {
    /**
     * filterNullGson
     */
    private static Gson filterNullGson;
    /**
     * nullableGson
     */
    private static Gson nullableGson;
    static {
        nullableGson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                .create();
        filterNullGson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                .create();
    }

    /**
     * Gson util.
     */
    protected GsonUtil() {
    }

    /**
     * 根据对象返回json   不过滤空值字段
     *
     * @param obj the obj
     * @return the string
     * @author : ligangwei / 2019-05-29
     */
    public static String toJsonWtihNullField(Object obj){
        return nullableGson.toJson(obj);
    }

    /**
     * 根据对象返回json  过滤空值字段
     *
     * @param obj the obj
     * @return the string
     * @author : ligangwei / 2019-05-29
     */
    public static String toJsonFilterNullField(Object obj){
        return filterNullGson.toJson(obj);
    }

    /**
     * 将json转化为对应的实体对象
     * new TypeToken<HashMap<String, Object>>(){}.getType()
     *
     * @param <T>  the type parameter
     * @param json the json
     * @param type the type
     * @return the t
     * @author : ligangwei / 2019-05-29
     * exam : Integer[] intarray = GsonUtil.fromJson(intarraystr,new TypeToken<Integer[]>(){}.getType());
     */
    public static <T>  T fromJson(String json, Type type){
        return nullableGson.fromJson(json, type);
    }
}
