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
	
	//페이지 번호
	private Integer page_no;
	//페이지 사이즈
	private Integer page_size=10;
	//현재 페이지
	private Integer current_page_no;
	//페이징 처리 : 현재 페이지번호를 받아서 시작
	public void setCurPageNo() {
		this.current_page_no = (this.page_no -1) * this.page_size;
	}	
}
