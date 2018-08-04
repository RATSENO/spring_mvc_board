package com.ratseno.board.member.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ratseno.board.common.model.CommonVO;

public class MemberLoginReq extends CommonVO{

	//회원 ID
	private String user_id;
	//회원 비밀번호
	private String user_pwd;
	
	private boolean user_cookie;
	
}
