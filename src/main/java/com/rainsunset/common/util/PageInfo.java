package com.rainsunset.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分页返回体
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.04.16
 * @Version : 1.0
 */
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 5689097937777375052L;
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
     * 数据总长度
     */
    private Integer totalSize = 0;

    /**
     * 数据
     */
    private List<T> rows;

    public PageInfo(int totalPage, int currentPage, Integer pageSize, Integer totalSize, List<T> rows) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        if (null == rows) {
            rows = new ArrayList<>();
        }
        this.rows = rows;
    }

    public PageInfo(PageHelper pageHelper, List<T> rows) {
        this.totalPage = pageHelper.getTotalPage();
        this.currentPage = pageHelper.getCurrentPage();
        this.pageSize = pageHelper.getPageSize();
        this.totalSize = pageHelper.getTotalSize();
        if (null == rows) {
            rows = new ArrayList<>();
        }
        this.rows = rows;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (null == currentPage || currentPage < 0) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (null == pageSize || pageSize < 0) {
            this.pageSize = 20;
        }
        this.pageSize = (pageSize > 200) ? 200 : pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                '}';
    }
}
