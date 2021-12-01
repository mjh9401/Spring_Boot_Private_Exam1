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
	
		
	// 임시 비밀번호 발송
	@RequestMapping("/usr/member/findLoginPw")
	public String findLoginPw() {
		return "usr/member/findLoginPw";
	}
	
	@RequestMapping("/usr/member/getLoginIdDup")
	@ResponseBody
	public String getLoginIdDup(String loginId) {
		if(Ut.empty(loginId)) {
			return "아이디를 입력해주세요";		
		}
		
		Member oldMember = memberService.getMemberByLoginId(loginId);
		
		if(oldMember != null) {
			return "해당 로그인 아이디는 사용중입니다.";
		}
		return "사용가능한 로그인 아이디입니다.";
	}
	
	
	@RequestMapping("/usr/member/dofindLoginPw")
	@ResponseBody
	public String dofindLoginPw(String name,String loginId,String email) {
		
		if(Ut.empty(name)) {
			return Ut.jsHistoryBack("이름를 입력해주세요");
		}
	
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요");
		}

		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일을 입력해주세요");
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return Ut.jsHistoryBack("존재하지 않는 회원입니다.");
		}
		
		if(member.getLoginId().equals(loginId) == false) {
			return Ut.jsHistoryBack("일치하지 않는 회원입니다.");
		}
		
		memberService.notifyTempLoginPwByEmail(member);
		
		return Ut.jsHistoryReplace("임시비밀번호가 전송됐습니다.", "/");
	}
	
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
		
		Member member = memberService.getMemberByLoginId(loginId);

		// 회원이 존재하지 않을경우
		if(member == null) {
			return Ut.jsHistoryBack("존재하지 않는 회원입니다.");
		}
		
		// 비번이 틀린경우
		if(member.getLoginPassword().equals(loginPassword) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
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
		
		return Ut.jsHistoryReplace("로그아웃 됐습니다.", "/");
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
	@RequestMapping("/usr/member/join")
	public String showJoin() {
		return "/usr/member/join";
	}
	
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public String doJoin(String loginId,String password,String name,String nickname,String tel,String email) {
		
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디가 없습니다.");
		}
		if(Ut.empty(password)) {
			return Ut.jsHistoryBack("비밀번호가 없습니다.");
		}
		if(Ut.empty(name)) {
			return Ut.jsHistoryBack("이름이 없습니다.");
		}
		if(Ut.empty(nickname)) {
			return Ut.jsHistoryBack("닉네임이 없습니다.");
		}
		if(Ut.empty(tel)) {
			return Ut.jsHistoryBack("전화번호가 없습니다.");
		}
		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일이 없습니다.");
		}
		Member oldMember = memberService.getMemberByLoginId(loginId);
		
		memberService.doJoin(loginId, password, name, nickname, tel, email);
		
		return Ut.jsHistoryReplace("회원가입이 완료됐습니다.", "/");
	}
	
	// 회원조회
	@RequestMapping("/usr/member/search")
	@ResponseBody
	public Member SearchMember(String name, String email) {
		return memberService.search(name,email);
	}
	
	@RequestMapping("/usr/member/ckPassword")
	public String ckPassword() {
		return "/usr/member/checkPassword";
	}
	
	@RequestMapping("/usr/member/doCkPassword")
	@ResponseBody
	public String doCkPassword(int id,String password) {
		Member member = memberService.getMemberById(id);
		
		if(member.getLoginPassword().equals(password) == false) {
			return Ut.jsHistoryBack("비번이 일치하지 않습니다.");
		}
		
		return Ut.jsHistoryReplace("비밀번호가 일치합니다.", "/usr/member/modify");
	}
		
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
