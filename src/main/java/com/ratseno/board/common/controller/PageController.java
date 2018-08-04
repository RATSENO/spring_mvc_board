package com.ratseno.board.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@RequestMapping(value="/{depth1}/page")
	public String goDepth1(@PathVariable String depth1, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String returnUrl = "";
		
		returnUrl = depth1;
		
		return returnUrl;
	}
	
	@RequestMapping(value="/{depth1}/{depth2}/page")
	public String goDepth2(@PathVariable String depth1, @PathVariable String depth2, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String returnUrl = "";
		
		returnUrl = depth1 + "/" + depth2;
		
		return returnUrl;
	}
	

}
