package com.ratseno.board.board.model.req;

import lombok.Data;

@Data
public class ReplyReq {
	
	// 댓글 번호
	Integer reply_no;
	// 게시물 번호
	Integer board_no;
	// 댓글 내용
	String reply_text;
	// 댓글 등록자
	String replyer;
}
