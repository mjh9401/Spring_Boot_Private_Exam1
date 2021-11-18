package com.mjh.exam.projoect1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.dao.ArticleDao;
import com.mjh.exam.projoect1.vo.Article;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public Article showdetail(String title, String body) {
		return articleDao.showdetail(title,body);
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

	public List<Article> getForPrintArticles(int boardId, int page, int itemsCountInPage) {
		int limitStart = (page -1) * itemsCountInPage;
		int limitTake = itemsCountInPage;
			
		return articleDao.getForPrintArticles(boardId,limitStart,limitTake);
	}

	public int getArticlesCount(int boardId) {
		return articleDao.getArticlesCount(boardId);
	}
}
