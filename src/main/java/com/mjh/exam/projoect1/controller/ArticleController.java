package com.mjh.exam.projoect1.controller;

import java.util.List;

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

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BoardService boardService;
	
	// 게시글 모두 조회
	@RequestMapping("/usr/article/list")
	public String showList(Model model, @RequestParam(defaultValue ="1") int boardId) {
		Board board = boardService.getBoardById(boardId);
		
		if(board == null) {
			return Ut.jsHistoryBack("게시물이 존재하지 않습니다.");
		}
		// 해당 게시물 글 찾기
		List<Article> articles = articleService.getForPrintArticles(boardId);
		// 한 페이지 안에 표현할 게시글 수
		int itemCountInPage = 10;
		// 해당 게시물 전체 글 갯수
		int articlesCount = articleService.getArticlesCount(boardId);
		
		model.addAttribute("articles", articles);
		model.addAttribute("itemCountInPage", itemCountInPage);
		model.addAttribute("articlesCount", articlesCount);
		
		return "usr/article/list";
	}
	
	// 게시글 키워드 조회
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showdetail(String title, String body) {
		return articleService.showdetail(title,body);
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
