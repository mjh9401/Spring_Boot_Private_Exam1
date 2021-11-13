package com.mjh.exam.projoect1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.service.MemberService;
import com.mjh.exam.projoect1.vo.Member;
import com.mjh.exam.projoect1.vo.loginInformation;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private loginInformation loginInformation;
	
	
	//로그인 화면
	@RequestMapping("/usr/member/login")
	public String showLogin() {
		return "usr/login/login";
	}
	
	//로그인
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPassword) {
		
		// 아이디 비밀번호 입력 안했을경우
		if(loginId.isEmpty()) {
			return Ut.jsHistoryBack("아이디를 입력하지 않았습니다.");
		}
		if(loginPassword.isEmpty()) {
			return Ut.jsHistoryBack("비밀번호가 입력하지 않았습니다.");
		}
		// 아이디 비밀번호가 틀린경우
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return Ut.jsHistoryBack("아이디 또는 비밀번호가 틀렸습니다.");
		}

		// 아이디 비밀번호가 모두 맞는 경우
		loginInformation.login(member);
		
		return Ut.jsHistoryReplace(Ut.f("%s님 환영합니다.",member.getNickname()),"/");
	}
	
	// 로그아웃
	@RequestMapping("/usr/member/dologout")
	@ResponseBody
	public String doLogout() {
		loginInformation.logout();
		
		return Ut.jsHistoryReplace("로그아웃됐습니다.", "/");
	}
	
	// 아이디찾기
	@RequestMapping("/usr/member/findId")
	public String showfindId() {
		return "/usr/member/findId";
	}
	
	@RequestMapping("/usr/member/finddoId")
	@ResponseBody
	public String dofindId(String name,String email) {
		// 이름 이메일을 입력 안했을경우
		if(name.isEmpty()) {
			return Ut.jsHistoryBack("이름을 입력하지 않았습니다.");
		}
		if(email.isEmpty()) {
			return Ut.jsHistoryBack("이메일을 입력하지 않았습니다.");
		}
		
		// 이름과 비밀번호가 틀린경우
		Member member = memberService.getMemberByNameAndEmail(name,email);
				
		if(member == null) {
			return Ut.jsHistoryBack("존재하지 않는 회원입니다.");
		}

		return Ut.jsHistoryReplace(Ut.f("%s님의 아이디는 %s입니다.",member.getName(),member.getLoginId()),"/");
	}
	
	
	// 회원가입
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public void doJoin(String loginId,String loginPassWord,String name,String nickName,String cellphonNO,String email) {
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
	public String showModifyMember() {
		
		return "/usr/member/modify";
	}
	
	// 회원정보수정
	@RequestMapping("/usr/member/domodify")
	@ResponseBody
	public String doModifyMember(int id,String password,String passwordConfirm,String nickname,String tel,String email) {	
		String Pw = password.trim();
		String PwConfirm = passwordConfirm.trim();
		
		// 비밀번호와 비밀번호 확인이 일치하지 않는경우
		if(Pw.equals(PwConfirm) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}
		
		// 회원정보 수정
		memberService.modifyMember(id,Pw,nickname,tel,email);
		
		
		return Ut.jsHistoryReplace("회원정보수정이 완료됐습니다.", "/");
	}
	
	// 회원탈퇴
	@RequestMapping("/usr/member/delete")
	@ResponseBody
	public void deleteMember(int id) {
		memberService.delete(id);
	}

	
}
