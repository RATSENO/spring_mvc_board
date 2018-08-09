package com.ratseno.board.common.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ratseno.board.member.model.res.MemberLoginRes;

@Component
@Aspect
public class LoginMemberInfoAspect {
	
	@Around("@annotation(LoginMemberInfo)")
	public Object setLoginMemberInfo(ProceedingJoinPoint joinPoint, HttpServletRequest request)throws Throwable {
		
		HttpSession session = request.getSession();
		MemberLoginRes memberLoginRes = (MemberLoginRes) session.getAttribute("LOGIN");
		
		return "hi";
	}

}
