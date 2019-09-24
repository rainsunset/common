package com.rainsunset.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> the type parameter
 * @description: 分页返回体
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.16
 * @version : 1.0
 */
public class PageInfo<T> implements Serializable {

    /**
     * serialversionUID
     */
    private static final long serialversionUID = 5689097937777375052L;
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

    /**
     * Page info.
     *
     * @param totalPage   the total page
     * @param currentPage the current page
     * @param pageSize    the page size
     * @param totalSize   the total size
     * @param rows        the rows
     */
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

    /**
     * Page info.
     *
     * @param pageHelper the page helper
     * @param rows       the rows
     */
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

    /**
     * Get total page integer.
     *
     * @return the integer
     * @author : ligangwei / 2019-09-24
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    /**
     * Sets total page.
     *
     * @param totalPage the total page
     * @author : ligangwei / 2019-09-24
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * Get current page integer.
     *
     * @return the integer
     * @author : ligangwei / 2019-09-24
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets current page.
     *
     * @param currentPage the current page
     * @author : ligangwei / 2019-09-24
     */
    public void setCurrentPage(Integer currentPage) {
        if (null == currentPage || currentPage < 0) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    /**
     * Get page size integer.
     *
     * @return the integer
     * @author : ligangwei / 2019-09-24
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     * @author : ligangwei / 2019-09-24
     */
    public void setPageSize(Integer pageSize) {
        if (null == pageSize || pageSize < 0) {
            this.pageSize = 20;
        }
        this.pageSize = (pageSize > 200) ? 200 : pageSize;
    }

    /**
     * Get total size integer.
     *
     * @return the integer
     * @author : ligangwei / 2019-09-24
     */
    public Integer getTotalSize() {
        return totalSize;
    }

    /**
     * Sets total size.
     *
     * @param totalSize the total size
     * @author : ligangwei / 2019-09-24
     */
    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    /**
     * Get rows list.
     *
     * @return the list
     * @author : ligangwei / 2019-09-24
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * Sets rows.
     *
     * @param rows the rows
     * @author : ligangwei / 2019-09-24
     */
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
