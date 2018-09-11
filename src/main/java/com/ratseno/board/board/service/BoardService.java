package com.ratseno.board.board.service;

import java.util.List;

import com.ratseno.board.board.model.req.BoardModReq;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.model.req.BoardSearchReq;
import com.ratseno.board.board.model.res.BoardListRes;
import com.ratseno.board.board.model.res.BoardRes;

public interface BoardService {
	
	/*게시물 등록*/
	public void boardRegist(BoardRegReq boardRegReq) throws Exception;
	
	/*게시물 수정*/
	public void boardMod(BoardModReq boardModReq) throws Exception;
	
	/*게시물 등록 테스트 100건*/
	public void boardTestRegist()throws Exception;
	
	/*게시물 목록 조회*/
	public BoardListRes boardList(BoardSearchReq boardSearchReq)throws Exception;

	/*게시물 상세 조회*/
	public BoardListRes boardDetail(BoardSearchReq boardSearchReq)throws Exception;

	/*게시물 테스트 전체 삭제*/
	public void boardTestDeleteAll()throws Exception;
}

