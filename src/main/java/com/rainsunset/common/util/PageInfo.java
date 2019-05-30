package com.rainsunset.common.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> the type parameter
 * @Description: 分页返回体
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.04.16
 * @Version : 1.0
 */
@JsonIgnoreProperties
public class PageInfo<T> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5689097937777375052L;
	/**
	 * 总页数
	 */
	private long totalPage = 0L;

	/**
	 * 当前页
	 */
	private long currentPage = 1L;

	/**
	 * 每页记录条数
	 */
	private Integer pageSize = 0;

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
	 * @param rows        the rows
	 */
	public PageInfo(long totalPage, long currentPage, Integer pageSize, List<T> rows) {
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
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
		if (null == rows) {
			rows = new ArrayList<>();
		}
		this.rows = rows;
	}

	/**
	 * Get total page long.
	 *
	 * @return the long
	 * @author : ligangwei / 2019-05-29
	 */
	public long getTotalPage() {
		return totalPage;
	}

	/**
	 * Sets total page.
	 *
	 * @param totalPage the total page
	 * @author : ligangwei / 2019-05-29
	 */
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * Get current page long.
	 *
	 * @return the long
	 * @author : ligangwei / 2019-05-29
	 */
	public Long getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets current page.
	 *
	 * @param currentPage the current page
	 * @author : ligangwei / 2019-05-29
	 */
	public void setCurrentPage(Long currentPage) {
		if (null == currentPage || currentPage < 0L) {
			currentPage = 1L;
		}
		this.currentPage = currentPage;
	}

	/**
	 * Get page size integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2019-05-29
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Sets page size.
	 *
	 * @param pageSize the page size
	 * @author : ligangwei / 2019-05-29
	 */
	public void setPageSize(Integer pageSize) {
		if (null == pageSize || pageSize < 0) {
			this.pageSize = 20;
		}
		this.pageSize = (pageSize > 200) ? 200 : pageSize;
	}

	/**
	 * Get rows list.
	 *
	 * @return the list
	 * @author : ligangwei / 2019-05-29
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * Sets rows.
	 *
	 * @param rows the rows
	 * @author : ligangwei / 2019-05-29
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
