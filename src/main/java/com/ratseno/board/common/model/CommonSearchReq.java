package com.ratseno.board.common.model;

import lombok.Data;

@Data
public class CommonSearchReq extends CommonVO {
	// 현재 페이지
	private Integer page;
	// 한 페이지의 출력 건수
	private Integer pageSize;
	// 현재 페이지 건수
	private Integer pageResultCount;
	// 전체 건수
	private Integer totalCount;

	private PageInfo pageInfo;

	public PageInfo getPageInfo() {
		if (page != null && pageSize != null && pageInfo == null) {
			pageInfo = new PageInfo(page, pageSize);
		}
		return pageInfo;
	}

}
