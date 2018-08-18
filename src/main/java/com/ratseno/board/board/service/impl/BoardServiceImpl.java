package com.ratseno.board.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.board.mapper.BoardMapper;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.model.req.BoardSearchReq;
import com.ratseno.board.board.model.res.BoardListRes;
import com.ratseno.board.board.model.res.BoardRes;
import com.ratseno.board.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	/*게시물 등록*/
	@Override
	public void boardRegist(BoardRegReq boardRegReq) throws Exception {
		int resultCnt = boardMapper.insertBoard(boardRegReq);
	}

	/*게시물 목록 조회*/
	@Override
	public BoardListRes boardList(BoardSearchReq boardSearchReq) throws Exception {
		BoardListRes res = new BoardListRes();
		
		List<BoardRes> boardList = boardMapper.selectBoardList(boardSearchReq);
		int boardCnt = boardMapper.selectBoardCnt(boardSearchReq);
		
		if(boardCnt == 0 && boardList.isEmpty()) {
			res.setBoardList(null);
		}
		
		res.setBoardList(boardList);
		return res;
	}

	/*게시물 상세 조회*/
	@Override
	public BoardListRes boardDetail(BoardSearchReq boardSearchReq) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
