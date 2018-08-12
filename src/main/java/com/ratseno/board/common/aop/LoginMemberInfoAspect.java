package com.ratseno.board.common.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ratseno.board.common.interceptor.AuthInterceptor;
import com.ratseno.board.member.model.res.MemberLoginRes;

@Component
@Aspect
public class LoginMemberInfoAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Around("@annotation(com.ratseno.board.common.annotation.LoginMemberInfo)")
	public Object setLoginMemberInfo(ProceedingJoinPoint joinPoint)throws Throwable {

		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for(Object o : joinPoint.getArgs()) {
			if(o instanceof HttpServletRequest) {
				request = (HttpServletRequest)o;
			}
			if(o instanceof HttpServletResponse) {
				response = (HttpServletResponse)o;
			}
		}
		
		HttpSession session = request.getSession();
		MemberLoginRes memberLoginRes = (MemberLoginRes) session.getAttribute("LOGIN");
		logger.info("memberLoginRes", memberLoginRes);

		Object result = joinPoint.proceed();
		
		return result;
	}

}
