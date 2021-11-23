package com.mjh.exam.projoect1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.Util.Ut;
import com.mjh.exam.projoect1.service.ArticleService;
import com.mjh.exam.projoect1.service.BoardService;
import com.mjh.exam.projoect1.vo.Article;
import com.mjh.exam.projoect1.vo.Board;
import com.mjh.exam.projoect1.vo.loginInformation;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private loginInformation loginInformation;
	
	// 게시글 모두 조회
	@RequestMapping("/usr/article/list")
	public String showList(HttpServletRequest req, Model model, @RequestParam(defaultValue ="1") int boardId,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue ="title,body") String searchKeywordTypeCode,
			@RequestParam(defaultValue = "") String searchKeyword) {
		Board board = boardService.getBoardById(boardId);
		HttpSession boardIdSession = req.getSession();
		
		if(board == null) {
			return Ut.jsHistoryBack("게시물이 존재하지 않습니다.");
		}
		// 한 페이지 안에 표현할 게시글 수
		int itemsCountInPage = 10;
		
		// 해당 게시물 글 찾기
		List<Article> articles = articleService.getForPrintArticles(boardId,page,itemsCountInPage,searchKeyword,searchKeywordTypeCode);
		
		
		// 해당 게시물 전체 글 갯수
		int articlesCount = articleService.getArticlesCount(boardId);
		
		// 페이지 카운트
		int pagesCount = (int) Math.ceil((double)articlesCount / itemsCountInPage);
		
		boardIdSession.setAttribute("boardId", boardId);
		model.addAttribute("articles", articles);
		model.addAttribute("itemsCountInPage", itemsCountInPage);
		model.addAttribute("articlesCount", articlesCount);
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		
		return "usr/article/list";
	}
	
	// 게시글 자세히
	@RequestMapping("/usr/article/detail")
	public String showdetail(Model model,int id) {
		Article article = articleService.getArticlesById(id);
		
		model.addAttribute("article", article);
		return "usr/article/detail";
	}
	
	// 게시글 쓰기 페이지이동
	@RequestMapping("usr/article/showWrite")
	public String showWirte() {
		return "usr/article/write";
	}
	
	// 게시글쓰기
	@RequestMapping("usr/article/dowrite")
	@ResponseBody
	public String doWrite(int boardId,int memberId, String title, String body) {
				
		if(Ut.empty(boardId)){
			return Ut.jsHistoryBack("게시판 선택이 잘못 됐습니다.");
		}
		
		if(Ut.empty(title)) {
			return Ut.jsHistoryBack("제목이 없습니다.");
		}
		
		if(Ut.empty(body)) {
			return Ut.jsHistoryBack("내용이 없습니다.");
		}
		
		articleService.write(boardId,memberId,title,body);
		
		return Ut.jsHistoryReplace("글 작성이 완료됐습니다.", "/");
	}
	
	// 게시글 삭제
	@RequestMapping("usr/article/delete")
	@ResponseBody
	public String deleteArticle(int id) {
		
		articleService.deleteArticle(id);
		
		return Ut.jsHistoryReplace("게시글 삭제가 완료됐습니다.", "/");
	}
	
	// 게시글 수정 페이지로 이동
	@RequestMapping("usr/article/showModify")
	public String showModify(Model model,int id) {
		Article article = articleService.getArticlesById(id);
		
		model.addAttribute("article", article);
		
		return "usr/article/modify";
	}
	
	// 게시글 수정
	@RequestMapping("usr/article/modify")
	@ResponseBody
	public String modifyArticle(int id, String title, String body) {
		articleService.modify(id,title,body);
		
		return Ut.jsHistoryReplace("게시글 수정이 완료됐습니다.", "/");
	}
	
}
