package com.ratseno.board.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratseno.board.member.model.req.MemberLoginReq;
import com.ratseno.board.member.model.res.MemberLoginRes;
import com.ratseno.board.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/loginPost", method=RequestMethod.POST)
	public void loginPOST(MemberLoginReq req, HttpSession session, Model model)throws Exception{
		MemberLoginRes memberLoginRes = memberService.login(req);
		
		if(memberLoginRes == null) {
			return;
		}
		
		model.addAttribute("memberLoginRes", memberLoginRes);
	}
	

}
