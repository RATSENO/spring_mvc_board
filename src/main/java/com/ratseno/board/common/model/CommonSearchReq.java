package com.ratseno.board.common.model;

import lombok.Data;

@Data
public class CommonSearchReq extends CommonVO{
	
	private Integer page;
	
	private Integer pageSize;
	
	private Integer pageResultCount;
	
	private Integer totalCount;
	
	private PageInfo pageInfo;
	
	public PageInfo getPageInfo() {
		if(page != null && pageSize != null && pageInfo == null) {
			pageInfo = new PageInfo(page, pageSize);
		}
		return pageInfo;
	}
	

}
