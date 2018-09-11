package com.ratseno.board.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.board.mapper.BoardMapper;
import com.ratseno.board.board.model.req.BoardModReq;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.model.req.BoardSearchReq;
import com.ratseno.board.board.model.res.BoardListRes;
import com.ratseno.board.board.model.res.BoardRes;
import com.ratseno.board.board.service.BoardService;
import com.ratseno.board.common.model.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	/*게시물 등록*/
	@Override
	public void boardRegist(BoardRegReq boardRegReq) throws Exception {
		int resultCnt = boardMapper.insertBoard(boardRegReq);
	}

	/*게시물 등록 테스트 100건*/
	@Override
	public void boardTestRegist() throws Exception {
		BoardRegReq testReq = null;
		
		for(int i=0; i<100; i++) {
			testReq = new BoardRegReq();
			testReq.setReg_no(1);
			testReq.setBoard_title("test"+i);
			testReq.setBoard_content("test"+i);
			
			boardMapper.insertBoard(testReq);
		}
	}
	
	/*게시물 목록 조회*/
	@Override
	public BoardListRes boardList(BoardSearchReq boardSearchReq) throws Exception {
		BoardListRes res = new BoardListRes();
		PageInfo pageInfo = new PageInfo();
		boardSearchReq.setCurPageNo();
		
		List<BoardRes> boardList = boardMapper.selectBoardList(boardSearchReq);
		int boardCnt = boardMapper.selectBoardCnt(boardSearchReq);
		
		if(boardCnt == 0 && boardList.isEmpty()) {
			res.setBoardList(null);
		}
		
		pageInfo.setPage_no(boardSearchReq.getPage_no());
		pageInfo.setPage_size(boardSearchReq.getPage_size());
		pageInfo.setPage_result_count(boardList.size());
		pageInfo.setTotal_count(boardCnt);
		
		res.setPageInfo(pageInfo);
		res.setBoardList(boardList);
		
		return res;
	}

	/*게시물 상세 조회*/
	@Override
	public BoardListRes boardDetail(BoardSearchReq boardSearchReq) throws Exception {
		BoardListRes res = new BoardListRes();
		PageInfo pageInfo = new PageInfo();
		
		boardSearchReq.setPage_no(1);
		boardSearchReq.setPage_no(10);
		boardSearchReq.setCurPageNo();
		
		List<BoardRes> boardList = boardMapper.selectBoardDetail(boardSearchReq);
		int boardCnt = boardMapper.selectBoardCnt(boardSearchReq);
		
		if(boardCnt == 0 && boardList.isEmpty()) {
			res.setBoardList(null);
		}
		
		pageInfo.setPage_no(boardSearchReq.getPage_no());
		pageInfo.setPage_size(boardSearchReq.getPage_size());
		pageInfo.setPage_result_count(boardList.size());
		pageInfo.setTotal_count(boardCnt);
		res.setPageInfo(pageInfo);
		res.setBoardList(boardList);
		
		return res;
	}

	/*게시물 테스트 전체 삭제*/
	@Override
	public void boardTestDeleteAll() throws Exception {
		int delete = boardMapper.deleteBoardAll();
	}

	/*게시물 수정*/
	@Override
	public void boardMod(BoardModReq boardModReq) throws Exception {
		int resultCnt = boardMapper.updateBoard(boardModReq);
	}



}
