package com.ratseno.board.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.board.mapper.BoardMapper;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public void boardRegist(BoardRegReq boardRegReq) throws Exception {
		int resultCnt = boardMapper.insertBoard(boardRegReq);
	}

}
