package com.rainsunset.common.util;

/**
 * @ClassName PageHelper
 * @Description: 分页参数处理
 * @Author: 李刚伟
 * @Company rainsunset
 * @CreateDate: 2019/4/16 19:43
 */
public class PageHelper {

    /**
     * 总页数
     */
    private Integer totalPage = 0;

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页记录条数
     */
    private Integer pageSize = 0;

    /**
     * Sql查询偏移量
     */
    private Integer offset = 0;

    /**
     * 数据总长度
     */
    private Integer totalSize = 0;

    public PageHelper(Integer currentPage, Integer pageSize, Integer totalSize) {
        this.pageSize = (null == pageSize || 1 > pageSize) ? 20 : ((200 < pageSize) ? 200 : pageSize);
        if (null == totalSize || 0 > totalSize) {
            this.totalSize = 0;
            this.currentPage = 1;
            this.totalPage = 0;
            this.offset = 0;
        } else {
            this.totalSize = totalSize;
            this.currentPage = (null == currentPage || 1 > currentPage) ? 1 : currentPage;
            this.totalPage = (this.totalSize / this.pageSize) + ((this.totalSize % this.pageSize) > 0 ? 1 : 0);
            this.offset = this.pageSize * (this.currentPage - 1);
        }
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getTotalSize() {
        return totalSize;
    }
}
