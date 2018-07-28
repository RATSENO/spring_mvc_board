package com.ratseno.board.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PageInfo extends CommonVO {

	// 현재 페이지
	private Integer page;
	// 한 페이지의 출력 건수
	private Integer pageSize;
	// 현재 페이지 건수
	private Integer pageResultCount;
	// 전체 건수
	private Integer totalCount;

	@JsonIgnore
	private Integer startRowNum;
	@JsonIgnore
	private Integer endRowNum;

	public PageInfo() {
		super();
	}

	public PageInfo(int page, int pageSize, int pageResultCount, int totalCount) {
		this.page = page;
		this.pageSize = pageSize;
		this.pageResultCount = pageResultCount;
		this.totalCount = totalCount;
	}

	public PageInfo(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	// paging
	public Integer getStartRowNum() {
		return ((page - 1) * pageSize);
	}

	// paging
	public Integer getEndRowNum() {
		return (page) * pageSize;
	}

}
