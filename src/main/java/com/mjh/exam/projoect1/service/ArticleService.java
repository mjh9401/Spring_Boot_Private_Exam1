package com.mjh.exam.projoect1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.dao.ArticleDao;
import com.mjh.exam.projoect1.vo.Article;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public Article list() {
		return articleDao.list();
	}
}
