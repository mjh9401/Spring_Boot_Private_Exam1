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

	public Article SearchKeyWord(String title, String body) {
		return articleDao.SearchKeyWord(title,body);
	}

	public void write(String title, String body) {
		articleDao.write(title,body);
	}

	public void deleteArticle(int id) {
		articleDao.deleteArticle(id);
	}

	public void modify(int id, String title, String body) {
		articleDao.modify(id,title,body);
	}
}
