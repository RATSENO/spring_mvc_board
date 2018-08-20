package com.ratseno.board.board.model.res;

import com.ratseno.board.common.model.CommonVO;

import lombok.Data;

@Data
public class BoardRes extends CommonVO{
	
	//게시물 번호
	int board_no;
	
	String board_title;
	
	String board_content;
	
	String reg_no;
}
