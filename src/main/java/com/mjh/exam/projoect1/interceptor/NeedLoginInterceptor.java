package com.mjh.exam.projoect1.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mjh.exam.projoect1.vo.loginInformation;

@Component
public class NeedLoginInterceptor implements HandlerInterceptor {
	@Autowired
	private loginInformation loginInformation;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(!loginInformation.isLogined()) {
			//DataBase에 변화를 주는 경우(C,U,D) Redirect를, 변화를 주지 않으면 forward(R) 를 쓴다.
			
			//RequestDispatcher rd = request.getRequestDispatcher("/usr/member/login");
			//rd.forward(request, response);
			
			//response.sendRedirect("/usr/member/login");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인을 해주세요');"
					+ "location.href='/usr/member/login';"
					+ "</script>");
			out.flush();
			out.close();

			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	 
	
}
