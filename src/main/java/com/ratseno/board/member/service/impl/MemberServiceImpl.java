package com.ratseno.board.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.member.mapper.MemberMapper;
import com.ratseno.board.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public String getTime() {
		return memberMapper.getTime();
	}

}
