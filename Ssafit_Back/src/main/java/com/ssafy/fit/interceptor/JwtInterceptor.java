package com.ssafy.fit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.fit.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor{

	private static final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//먼저 한 번 검증을 하기 위해 던져보는 것(OPTION)?
		if(request.getMethod().equals("OPTIONS"))
			return true;
		
		String token = request.getHeader(HEADER_AUTH);
		
		//토큰이 있는 경우
		if (token != null) {
			//유효하다면?
			jwtUtil.validCheck(token);
			return true; //진행시켜
		}
		//토큰이 없거나 유효하지 않다면
		throw new Exception("유효하지 않은 접근입니다.");
	}
	
	
}
