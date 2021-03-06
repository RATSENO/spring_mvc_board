package com.ratseno.board.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratseno.board.board.model.req.BoardModReq;
import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.model.req.BoardSearchReq;
import com.ratseno.board.board.model.res.BoardListRes;
import com.ratseno.board.board.model.res.BoardRes;
import com.ratseno.board.board.service.BoardService;
import com.ratseno.board.common.annotation.LoginMemberInfo;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	

	/*게시물 등록*/
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	@LoginMemberInfo
	public ResponseEntity<String> boardRegist(HttpServletRequest request, @RequestBody BoardRegReq boardRegReq){
		ResponseEntity<String> entity = null;
		BoardRegReq req = boardRegReq;
		
		try {
			boardService.boardRegist(req);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*게시물 전체 목록 조회*/
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResponseEntity<BoardListRes> boardList(HttpServletRequest request, @RequestBody BoardSearchReq boardSearchReq){
		ResponseEntity<BoardListRes> entity = null;
		BoardSearchReq req = boardSearchReq;
		
		BoardListRes res = new BoardListRes();
		
		try {
			res = boardService.boardList(req);
			entity = new ResponseEntity<BoardListRes>(res, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<BoardListRes>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*게시물 내 목록 조회*/
	@RequestMapping(value="/mylist", method=RequestMethod.POST)
	@LoginMemberInfo
	public ResponseEntity<BoardListRes> boardMyList(HttpServletRequest request, @RequestBody BoardSearchReq boardSearchReq){
		ResponseEntity<BoardListRes> entity = null;
		BoardSearchReq req = boardSearchReq;
		
		BoardListRes res = new BoardListRes();
		
		try {
			res = boardService.boardList(req);
			entity = new ResponseEntity<BoardListRes>(res, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<BoardListRes>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*게시물 상세 조회*/
	@RequestMapping(value="/detail", method=RequestMethod.POST)
	public ResponseEntity<BoardListRes> boardDetail(HttpServletRequest request, @RequestBody BoardSearchReq boardSearchReq){
		ResponseEntity<BoardListRes> entity = null;
		BoardSearchReq req = boardSearchReq;
		
		BoardListRes res = new BoardListRes();
		
		try {
			res = boardService.boardDetail(req);
			entity = new ResponseEntity<BoardListRes>(res, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<BoardListRes>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*게시물 수정*/
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@LoginMemberInfo
	public ResponseEntity<String> boardModify(HttpServletRequest request, @RequestBody BoardModReq boardModReq){
		ResponseEntity<String> entity = null;
		BoardModReq req = boardModReq;
		
		try {
			boardService.boardMod(req);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	
	
	
	@RequestMapping(value="/testBoardRegist", method= RequestMethod.POST)
	public void test100boardRegist() throws Exception {
		boardService.boardTestRegist();
	}
	
	@RequestMapping(value="/testBoardDelete", method=RequestMethod.POST)
	public void testBoardDelete() throws Exception {
		boardService.boardTestDeleteAll();
	}
	
	

}
