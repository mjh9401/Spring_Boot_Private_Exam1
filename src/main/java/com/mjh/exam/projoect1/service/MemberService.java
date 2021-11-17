package com.mjh.exam.projoect1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.dao.MemberDao;
import com.mjh.exam.projoect1.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private UsrMailService UsrMailService;
    @Value("${custom.siteMainUri}")
	private String siteMainUri;
    @Value("${custom.siteName}")
    private String siteName;

	public void doJoin(String loginId, String loginPassWord, String name, String nickName,
			String cellphonNO, String email) {
		memberDao.doJoin(loginId,loginPassWord,name,nickName,cellphonNO,email);
	}

	public Member search(String name, String email) {
		return memberDao.search(name,email);
	}

	public void Modify(int id, String name, String nickName, 
			String cellphonNo, String email) {
		
		memberDao.modify(id,name,nickName,cellphonNo,email);
	}

	public void delete(int id) {
		memberDao.delete(id);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberByNameAndEmail(String name, String email) {
		return memberDao.getMemberByNameAndEmail(name,email);
	}
	
	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}

	public void modifyMember(int id, String pw,String nickname, String tel, String email) {
		memberDao.modifyMember(id,pw,nickname,tel,email);		
	}

	public String notifyTempLoginPwByEmail(Member member) {
		String title = "[" + siteName + "] 임시 패스워드 발송";
        String tempPassword = Ut.getTempPassword(6);
        String body = "<h1>임시 패스워드 : " + tempPassword + "</h1>";
        body += "<a href=\"" + siteMainUri + "/mpaUsr/member/login\" target=\"_blank\">로그인 하러가기</a>";

        String Result = UsrMailService.send(member.getEmail(), title, body);

        if (Result.contains("실패")) {
            return "메일 발송에 실패했습니다.";
        }

        setTempPassword(member, tempPassword);

        return "계정의 이메일주소로 임시 패스워드가 발송되었습니다.";
		
	}

	private void setTempPassword(Member member, String tempPassword) {
		memberDao.remodify(member.getId(),tempPassword, null, null, null, null);
	}

	

	

	
	
	
}
