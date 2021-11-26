package com.mjh.exam.projoect1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.service.ArticleService;
import com.mjh.exam.projoect1.service.ReplyService;
import com.mjh.exam.projoect1.vo.Article;
import com.mjh.exam.projoect1.vo.Reply;
import com.mjh.exam.projoect1.vo.loginInformation;

@Controller
public class ReplyController {
	@Autowired
	private ArticleService articleService;
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
	
	// 댓글 삭제
	@RequestMapping("usr/reply/delete")
	@ResponseBody
	public String doDelete(int id) {
		Reply reply = replyService.getReplyIdById(id);
		int articleId = reply.getArticleId();
		
		replyService.doDelete(id);
				
		return Ut.jsHistoryReplace("댓글 삭제됐습니다.","/usr/article/detail?id="+articleId);
	}
	
	@RequestMapping("usr/reply/showModify")
	public String showModify(HttpServletRequest req,Model model,int id) {
		HttpSession session = req.getSession();
		int boardId = (int) session.getAttribute("boardId");
		int memberId = loginInformation.getLoginMemberId();
		
		List<Reply> replies = replyService.getForPrintReplies(boardId,id,memberId);
		Article article = articleService.getArticlesByBoardId(id);
	

		model.addAttribute("replies", replies);
		model.addAttribute("article", article);
		
		return "usr/reply/modify";
	}
	
	@RequestMapping("usr/reply/doModify")
	@ResponseBody
	public String doModify(int id,String body) {
		Reply reply = replyService.getReplyIdById(id);
		
		int articleId = reply.getArticleId();
		
		replyService.doModify(id,body);
		
		return Ut.jsHistoryReplace("댓글 수정됐습니다.", "/usr/article/detail?id="+articleId);
	}
	
}
