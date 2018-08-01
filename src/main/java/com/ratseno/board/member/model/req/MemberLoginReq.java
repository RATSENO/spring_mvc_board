package com.ratseno.board.member.model.req;

import com.ratseno.board.common.model.CommonVO;

public class MemberLoginReq extends CommonVO{

	//회원 번호
	private Integer userNo;
	//회원 ID
	private String userId;
	
	private boolean userCookie;
	
}
