package com.ratseno.board.board.mapper;

import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.common.annotation.Mapper;

@Mapper
public interface BoardMapper {
	
	/*게시물 등록*/
	public int insertBoard(BoardRegReq boardRegReq) throws Exception;

}
