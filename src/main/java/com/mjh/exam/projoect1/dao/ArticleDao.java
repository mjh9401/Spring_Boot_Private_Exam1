package com.mjh.exam.projoect1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Article;

@Mapper
public interface ArticleDao {

	Article showdetail(@Param("title") String title,@Param("body") String body);

	void write(@Param("title") String title, @Param("body") String body);

	void deleteArticle(@Param("id") int id);

	void modify(@Param("id") int id, @Param("title") String title,@Param("body") String body);

	List<Article> getForPrintArticles(@Param("boardId") int boardId);

	int getArticlesCount(@Param("boardId") int boardId);

}
