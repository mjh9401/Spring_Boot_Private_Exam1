package com.mjh.exam.projoect1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mjh.exam.projoect1.vo.loginInformation;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
	@Autowired
	private loginInformation loginInformation;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getSession().setAttribute("loginInformation", loginInformation);
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	 
	
}
