package com.ratseno.board.member.model.res;

import com.ratseno.board.common.model.CommonVO;

import lombok.Data;

@Data
public class MemberLoginRes extends CommonVO{
	
	//회원 번호
	private Integer userNo;
	//회원 이름
	private String userName;
	//회원 ID
	private String userId;
	//회원 비밀번호
	private String userPwd;
	//회원 이메일
	private String userEmail;
	//회원 전화번호
	private String userPhoneNumber;
}
