package com.mjh.exam.projoect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mjh.exam.projoect1.interceptor.BeforeActionInterceptor;
import com.mjh.exam.projoect1.interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration ir;
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.excludePathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
		
		ir = registry.addInterceptor(needLoginInterceptor);
		ir.addPathPatterns("/usr/article/detail");
		ir.addPathPatterns("/usr/article/showWrite");
		ir.addPathPatterns("/usr/article/dowrite");
		ir.addPathPatterns("/usr/article/delete");
		ir.addPathPatterns("/usr/article/showModify");
		ir.addPathPatterns("/usr/article/modify");
	
	}

}
