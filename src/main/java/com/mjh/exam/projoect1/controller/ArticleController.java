package com.mjh.exam.projoect1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.service.ArticleService;
import com.mjh.exam.projoect1.vo.Article;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	// 게시글 모두 조회
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public Article showList(String title,String body) {
		return articleService.list();
	}
	
	// 게시글 키워드 조회
	@RequestMapping("/usr/article/search")
	@ResponseBody
	public Article SearchKeyWord(String title, String body) {
		return articleService.SearchKeyWord(title,body);
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
