package com.rainsunset.common.util;

/**
 * @Description: 分页参数处理
 * @Author: 李刚伟
 * @Company rainsunset
 * @CreateDate: 2019 /4/16 19:43
 * @Version : 1.0
 * @ClassName PageHelper
 */
public class PageHelper {

	/**
	 * 总页数
	 */
	private Long totalPage = 0L;

	/**
	 * 当前页
	 */
	private Long currentPage = 1L;

	/**
	 * 每页记录条数
	 */
	private Integer pageSize = 0;

	/**
	 * Sql查询偏移量
	 */
	private Long offset = 0L;

	/**
	 * 数据总长度
	 */
	private Long totalSize = 0L;

	/**
	 * Page helper.
	 *
	 * @param currentPage the current page
	 * @param pageSize    the page size
	 * @param totalSize   the total size
	 */
	public PageHelper(Long currentPage,Integer pageSize,Long totalSize) {
		this.pageSize = (null == pageSize || 1 > pageSize) ? 20 : ((200 < pageSize) ? 200 : pageSize);
		if(null == totalSize || 0 > totalSize){
			this.totalSize = 0L;
			this.currentPage = 1L;
			this.totalPage = 0L;
			this.offset = 0L;
		} else {
			this.totalSize = totalSize;
			this.currentPage = (null == currentPage || 1 > currentPage) ? 1L : currentPage;
			this.totalPage = (this.totalSize / this.pageSize) +((this.totalSize % this.pageSize) > 0 ? 1 :0);
			this.offset = this.pageSize * (this.currentPage - 1);
		}
	}

	/**
	 * Get total page long.
	 *
	 * @return the long
	 * @author : ligangwei / 2019-05-29
	 */
	public Long getTotalPage() {
		return totalPage;
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
	 * Get page size integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2019-05-29
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Get offset long.
	 *
	 * @return the long
	 * @author : ligangwei / 2019-05-29
	 */
	public Long getOffset() {
		return offset;
	}
}
