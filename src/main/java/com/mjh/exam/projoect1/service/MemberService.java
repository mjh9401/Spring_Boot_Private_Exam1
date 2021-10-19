package com.mjh.exam.projoect1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.dao.MemberDao;
import com.mjh.exam.projoect1.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

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
	
	
}
