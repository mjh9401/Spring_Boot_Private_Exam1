package com.mjh.exam.projoect1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.service.MemberService;
import com.mjh.exam.projoect1.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 로그인
	@RequestMapping("/usr/member/login")
	public String showLogin() {
		return "usr/login/login";
	}
	
	// 회원가입
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public void doJoin(String loginId,String loginPassWord,String name,
			String nickName,String cellphonNO,String email) {
		memberService.doJoin(loginId,loginPassWord,name,nickName,cellphonNO,email);
	}
	
	// 회원조회
	@RequestMapping("/usr/member/search")
	@ResponseBody
	public Member SearchMember(String name, String email) {
		return memberService.search(name,email);
	}
	
	// 회원정보수정
	@RequestMapping("/usr/member/modify")
	@ResponseBody
	public void ModifyMember(int id,String name,String nickName,
			String cellphonNo,String email) {
		memberService.Modify(id,name,nickName,cellphonNo,email);
	}
	
	// 회원탈퇴
	@RequestMapping("/usr/member/delete")
	@ResponseBody
	public void deleteMember(int id) {
		memberService.delete(id);
	}
	
}
