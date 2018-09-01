package com.ratseno.board.board.model.res;

import com.ratseno.board.common.model.CommonVO;

import lombok.Data;

@Data
public class BoardRes extends CommonVO{
	
	//게시물 번호
	Integer board_no;
	
	String board_title;
	
	String board_content;
	
	Integer reg_no;
}
