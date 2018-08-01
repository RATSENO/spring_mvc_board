package com.ratseno.board.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.member.mapper.MemberMapper;
import com.ratseno.board.member.model.req.MemberLoginReq;
import com.ratseno.board.member.model.res.MemberLoginRes;
import com.ratseno.board.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public String getTime() {
		return memberMapper.getTime();
	}

	@Override
	public MemberLoginRes login(MemberLoginReq memberLoginReq) throws Exception {
		return memberMapper.login(memberLoginReq);
	}

}
