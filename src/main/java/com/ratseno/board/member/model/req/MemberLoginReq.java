package com.ratseno.board.member.model.req;

import com.ratseno.board.common.model.CommonVO;

import lombok.Data;

@Data
public class MemberLoginReq extends CommonVO{

	//회원 ID
	private String user_id;
	//회원 비밀번호
	private String user_pwd;
	//자동 로그인
	private boolean user_cookie;
	
}
