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
	public String showList(HttpServletRequest req,Model model, @RequestParam(defaultValue ="1") int boardId,
			@RequestParam(defaultValue = "1") int page) {
		Board board = boardService.getBoardById(boardId);
		HttpSession boardIdSession = req.getSession();
		
		if(board == null) {
			return Ut.jsHistoryBack("게시물이 존재하지 않습니다.");
		}
		// 한 페이지 안에 표현할 게시글 수
		int itemsCountInPage = 10;
		
		// 해당 게시물 글 찾기
		List<Article> articles = articleService.getForPrintArticles(boardId,page,itemsCountInPage);
		
		
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
	
	// 게시글 키워드 조회
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showdetail(String title, String body) {
		return articleService.showdetail(title,body);
	}
	
	// 게시글 쓰기 페이지이동
	@RequestMapping("usr/article/showWrite")
	public String showWirte() {
		return "usr/article/write";
	}
	
	// 게시글쓰기
	@RequestMapping("usr/article/write")
	@ResponseBody
	public void Write(String title, String body) {
		articleService.write(title,body);
	}
	
	// 게시글 삭제
	@RequestMapping("usr/article/delete")
	@ResponseBody
	public void deleteArticle(int id) {
		articleService.deleteArticle(id);
	}
	
	// 게시글 수정
	@RequestMapping("usr/article/modify")
	@ResponseBody
	public void modifyArticle(int id, String title, String body) {
		articleService.modify(id,title,body);
	}
	
}
