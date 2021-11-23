package com.mjh.exam.projoect1.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.service.MemberService;

import lombok.Getter;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class loginInformation {
	@Getter
	private boolean isLogined;
	@Getter
	private Member loginedMember;
	@Getter
	private int loginMemberId;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	public loginInformation(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
		this.req = req;
		this.resp = resp;
		this.session = req.getSession();
		
		if(session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginMemberId);
		}
		
		req.setAttribute("loginInformation", this);
	}

	public void login(Member member) {
		session.setAttribute("loginedMemberId", member.getId());
	}

	public void logout() {		
		session.invalidate();
	}

	public String printHistoryReplaceJs(String msg, String afterUri) {
		
		return Ut.jsHistoryReplace(msg, afterUri);
	}


}
