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
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public Article showList(String title,String body) {
		return articleService.list();
	}
}
