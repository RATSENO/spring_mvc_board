package com.ratseno.board.board.model.req;

import lombok.Data;

@Data
public class BoardModReq {
	//게시물 번호
	Integer board_no;
	//게시물 제목
	String board_title;
	//게시물 내용
	String board_content;
	//게시물 등록자 번호
	Integer reg_no;
}
