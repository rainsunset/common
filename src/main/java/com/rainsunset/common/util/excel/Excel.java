package com.rainsunset.common.util.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ligangwei
 * Excel注解，用以生成Excel表格文件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Excel {

    /**
     * 表格内容数据样式
     */
    int CELL_TYPE_NUMERIC = 0;

    int CELL_TYPE_STRING = 1;

    int CELL_TYPE_FORMULA = 2;

    int CELL_TYPE_BLANK = 3;

    int CELL_TYPE_BOOLEAN = 4;

    int CELL_TYPE_ERROR = 5;

    //百分比样式
    int CELL_TYPE_PERCENT = 6;

    /**
     * 表格内容排列样式
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

    int CELL_DEFAULT_DECIMAL_LENGTH = -1;

    int CELL_INT_DECIMAL_LENGTH = 0;

    //列名
    String name() default "";

    //宽度
    int width() default 20;

    //忽略该字段
    boolean skip() default false;

    int type() default 0; // 0 可不填   1 必填

    int cellType() default CELL_TYPE_STRING;

    short align() default ALIGN_LEFT;

    int decimalLength() default CELL_DEFAULT_DECIMAL_LENGTH;//-1 不处理 0:取整 >0:保留相应位数小数

}
