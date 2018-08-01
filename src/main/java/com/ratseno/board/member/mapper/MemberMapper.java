package com.ratseno.board.member.mapper;

import com.ratseno.board.common.annotation.Mapper;
import com.ratseno.board.member.model.req.MemberJoinReq;
import com.ratseno.board.member.model.req.MemberLoginReq;
import com.ratseno.board.member.model.res.MemberLoginRes;

@Mapper
public interface MemberMapper {
	
	public String getTime();
	
	/*ID 중복 체크*/
	public String selectDuplicationCheckUserId(MemberJoinReq memberJoinReq);
	
	/*이메일 중복 체크*/
	public String selectDuplicationCheckUserEmail(MemberJoinReq memberJoinReq);
	
	/*비밀번호 중복 체크*/
	public String selectDuplicationCheckUserPwd(MemberJoinReq memberJoinReq);
	
	/* 로그인 */
	public MemberLoginRes login(MemberLoginReq memberLoginReq);
	
}
