package com.mjh.exam.projoect1.vo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

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

	public String getCurrentUri() {
		String currentUri = req.getRequestURI();
        String queryString = req.getQueryString();

        if (queryString != null && queryString.length() > 0) {
            currentUri += "?" + queryString;
        }

        return currentUri;
	}

	public void printReplaceJs(String msg, String uri) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String Script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "location.replace('%s');"
				+ "</script>";
		
		out.printf(Script,msg,uri);
		out.flush();
		out.close();
	}
	
}
