package com.mjh.exam.projoect1.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mjh.exam.projoect1.Util.Ut;

import lombok.Getter;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class loginInformation {
	@Getter
	private boolean isLogined;
	@Getter
	private Member loginedMember;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	public loginInformation(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		this.session = req.getSession();
	}

	public void login(Member member) {
		this.isLogined = true;
		session.setAttribute("loginedMember", member);
		
		if(session.getAttribute("loginedMember") != null) {
			this.isLogined = true;
			this.loginedMember = (Member) session.getAttribute("loginedMember");
		}
		
		session.setAttribute("loginInformation", this);
		
	}

	public void logout() {		
		session.invalidate();
	}

	public void printHistoryReplaceJs(String msg, String afterUri) {
		Ut.jsHistoryReplace(msg, afterUri);
	}

}
