package com.ratseno.board.common.model;

import lombok.Data;

@Data
public class PageInfo{

	// 현재 페이지
	private Integer page_no;
	// 한 페이지의 출력 건수
	private Integer page_size;
	// 현재 페이지 건수
	private Integer page_result_count;
	// 전체 건수
	private Integer total_count;
}
