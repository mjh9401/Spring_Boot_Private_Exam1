package com.mjh.exam.projoect1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.service.ReplyService;
import com.mjh.exam.projoect1.vo.loginInformation;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private loginInformation loginInformation;
	
	
	// 댓글 작성
	@RequestMapping("usr/reply/dowrite")
	@ResponseBody
	public String doWrite(int articleId,int boardId,String body) {
		int memberId = loginInformation.getLoginMemberId();
		
		if(articleId == 0 ) {
			return Ut.jsHistoryReplace("로그인이 필요합니다.", "/");
		}
		
		if(Ut.empty(body)) {
			return Ut.jsHistoryReplace("댓글을 입력해주세요", "/usr/article/detail?id="+articleId);
		}
		
		replyService.doWrite(articleId,memberId,boardId,body);
		
		return Ut.jsHistoryReplace("댓글 작성이 완료됐습니다.", "/");
	}
	
}
