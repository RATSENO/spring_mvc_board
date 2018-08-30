package com.ratseno.board.board.model.res;

import com.ratseno.board.common.model.CommonVO;

import lombok.Data;

@Data
public class ReplyRes extends CommonVO{

	//댓글 번호
	Integer reply_no;
	//게시물 번호
	Integer board_no;
	//댓글 내용
	String reply_text;
	//댓글 등록자 
	String replyer;
	
}
