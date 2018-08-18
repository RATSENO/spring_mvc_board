package com.ratseno.board.common.model;

import lombok.Data;

@Data
public class CommonVO {
	
	private String reg_date; 	//등록일
	
	private String reg_id;   	//등록자 ID
	
	private String update_date; 	//수정일
	
	private String update_id;   	//수정자 ID
}
