package com.rainsunset.common.util;


import com.rainsunset.common.util.excel.Excel;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @param <T> the type parameter
 * @Description: TODO
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.05.29
 * @Version : 1.0
 */
public class ComparUtil<T> {

    /**
     * Contrast obj string.
     *
     * @param oldBean the old bean
     * @param newBean the new bean
     * @return the string
     * @author : ligangwei / 2019-05-29
     */
    public String contrastObj(Object oldBean, Object newBean) {
        String str = "";
        // if (oldBean instanceof SysConfServer && newBean instanceof
        // SysConfServer) {
        @SuppressWarnings("unchecked")
        T pojo1 = (T) oldBean;
        @SuppressWarnings("unchecked")
        T pojo2 = (T) newBean;
        try {
            @SuppressWarnings("rawtypes")
            Class clazz = pojo1.getClass();
            Field[] fields = pojo1.getClass().getDeclaredFields();
            int i = 1;
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                        clazz);
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(pojo1);
                Object o2 = getMethod.invoke(pojo2);
                Excel excel = field.getAnnotation(Excel.class);
                if (excel == null) {
                    continue;
                }
                if (o1 == null && o2 == null) {
                    continue;
                } else if (o1 == null) {
                    if (i != 1) {
                        str += ";";
                    }
                    str += i + "." + excel.name() + field.getName()
                            + " 由 ：《null》 更新为:《" + o2 + "》";
                    i++;
                } else if (o2 == null) {
                    if (i != 1) {
                        str += ";";
                    }
                    str += i + "." + excel.name() + field.getName() + " 由 ：《" + o1
                            + "》 更新为:《null》";
                    i++;
                } else if (!o1.toString().equals(o2.toString())) {
                    if (i != 1) {
                        str += ";";
                    }
                    str += i + "." + excel.name() + field.getName() + " 由 ：《" + o1
                            + "》 更新为:《" + o2 + "》";
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // }
        return str;
    }

}
