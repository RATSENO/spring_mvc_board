package com.ratseno.board.member.service;

import com.ratseno.board.member.model.req.MemberLoginReq;
import com.ratseno.board.member.model.res.MemberLoginRes;

public interface MemberService {
	
	public String getTime();
	
	public MemberLoginRes login(MemberLoginReq memberLoginReq) throws Exception;

}
