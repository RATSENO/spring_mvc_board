package com.ratseno.board.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommonVO {
	
	private String regDate; 	//등록일
	
	private String regId;   	//등록자 ID
	
	private String updateDate; 	//수정일
	
	private String updateId;   	//수정자 ID
}
