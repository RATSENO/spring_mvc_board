package com.ratseno.board.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommonVO {
	
	@JsonIgnore
	private String regDate; 	//등록일
	@JsonIgnore
	private String regId;   	//등록자 ID
	@JsonIgnore
	private String updateDate; 	//수정일
	@JsonIgnore
	private String updateId;   	//수정자 ID
}
