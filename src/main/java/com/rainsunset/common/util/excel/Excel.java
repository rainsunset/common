package com.rainsunset.common.util.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ligangwei  Excel注解，用以生成Excel表格文件
 * @description: TODO
 * @author: ligangwei
 * @company CMBI
 * @date: 2019.09.24
 * @version : 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Excel {

    /**
     * 表格内容数据样式
     */
    int CELL_TYPE_NUMERIC = 0;

    /**
     * The constant CELL_TYPE_STRING.
     */
    int CELL_TYPE_STRING = 1;

    /**
     * The constant CELL_TYPE_FORMULA.
     */
    int CELL_TYPE_FORMULA = 2;

    /**
     * The constant CELL_TYPE_BLANK.
     */
    int CELL_TYPE_BLANK = 3;

    /**
     * The constant CELL_TYPE_BOOLEAN.
     */
    int CELL_TYPE_BOOLEAN = 4;

    /**
     * The constant CELL_TYPE_ERROR.
     */
    int CELL_TYPE_ERROR = 5;

    /**
     * 百分比样式
     */
    int CELL_TYPE_PERCENT = 6;

    /**
     * 表格内容排列样式
     *
     * @return
     */
    short ALIGN_GENERAL = 0x0;

    /**
     * left-justified horizontal alignment
     */
    short ALIGN_LEFT = 0x1;

    /**
     * center horizontal alignment
     */
    short ALIGN_CENTER = 0x2;

    /**
     * right-justified horizontal alignment
     */
    short ALIGN_RIGHT = 0x3;

    /**
     * fill? horizontal alignment
     */
    short ALIGN_FILL = 0x4;

    /**
     * justified horizontal alignment
     */
    short ALIGN_JUSTIFY = 0x5;

    /**
     * center-selection? horizontal alignment
     */
    short ALIGN_CENTER_SELECTION = 0x6;

    /**
     * The constant CELL_DEFAULT_DECIMAL_LENGTH.
     */
    int CELL_DEFAULT_DECIMAL_LENGTH = -1;

    /**
     * The constant CELL_INT_DECIMAL_LENGTH.
     */
    int CELL_INT_DECIMAL_LENGTH = 0;

    /**
     * Name string.
     *
     * @return the string
     * @author : ligangwei / 2019-09-24
     */
//列名
    String name() default "";

    /**
     * Width int.
     *
     * @return the int
     * @author : ligangwei / 2019-09-24
     */
//宽度
    int width() default 20;

    /**
     * Skip boolean.
     *
     * @return the boolean
     * @author : ligangwei / 2019-09-24
     */
//忽略该字段
    boolean skip() default false;

    /**
     * Type int.
     *
     * @return the int
     * @author : ligangwei / 2019-09-24
     */
    int type() default 0; // 0 可不填   1 必填

    /**
     * Cell type int.
     *
     * @return the int
     * @author : ligangwei / 2019-09-24
     */
    int cellType() default CELL_TYPE_STRING;

    /**
     * Align short.
     *
     * @return the short
     * @author : ligangwei / 2019-09-24
     */
    short align() default ALIGN_LEFT;

    /**
     * Decimal length int.
     *
     * @return the int
     * @author : ligangwei / 2019-09-24
     */
    int decimalLength() default CELL_DEFAULT_DECIMAL_LENGTH;//-1 不处理 0:取整 >0:保留相应位数小数

}
