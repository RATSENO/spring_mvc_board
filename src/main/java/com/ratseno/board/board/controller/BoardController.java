package com.ratseno.board.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratseno.board.board.model.req.BoardRegReq;
import com.ratseno.board.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResponseEntity<String> boardRegist(@RequestBody BoardRegReq boardRegReq){
		ResponseEntity<String> entity = null;
		
		try {
			boardService.boardRegist(boardRegReq);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
