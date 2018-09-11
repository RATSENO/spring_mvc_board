package com.ratseno.board.board.mapper;

import java.util.List;

import com.ratseno.board.board.model.req.BoardModReq;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.model.req.BoardSearchReq;
import com.ratseno.board.board.model.res.BoardRes;
import com.ratseno.board.common.annotation.Mapper;

@Mapper
public interface BoardMapper {
	
	/*게시물 등록*/
	public int insertBoard(BoardRegReq boardRegReq) throws Exception;
	
	/*게시물 수정*/
	public int updateBoard(BoardModReq boardModReq) throws Exception;
	
	/*게시물 목록 조회*/
	public List<BoardRes> selectBoardList(BoardSearchReq boardSearchReq)throws Exception;

	/*게시물 상세 조회*/
	public List<BoardRes> selectBoardDetail(BoardSearchReq boardSearchReq)throws Exception;
	
	/*게시물 갯수 조회*/
	public int selectBoardCnt(BoardSearchReq boardSearchReq);
	
	/*게시물 전체 삭제*/
	public int deleteBoardAll();
}
