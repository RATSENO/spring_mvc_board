package com.ratseno.board.board.service;

import com.ratseno.board.board.model.req.BoardRegReq;

public interface BoardService {
	
	/*게시물 등록*/
	public void boardRegist(BoardRegReq boardRegReq) throws Exception;

}
