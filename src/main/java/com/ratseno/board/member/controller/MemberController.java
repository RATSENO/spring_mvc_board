package com.ratseno.board.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratseno.board.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/getTime")
	public String getTime() {
		String time  = "";
		time = memberService.getTime();
		return time;
	}

}
