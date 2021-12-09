package com.mjh.exam.projoect1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Article;

@Mapper
public interface ArticleDao {

	Article showdetail(@Param("title") String title,@Param("body") String body);

	void write(@Param("boardId") int boardId,@Param("memberId") int memberId, @Param("title") String title, @Param("body") String body);

	void deleteArticle(@Param("id") int id);

	void modify(@Param("id") int id, @Param("title") String title,@Param("body") String body);

	List<Article> getForPrintArticles(@Param("boardId") int boardId,@Param("limitStart") int limitStart,@Param("limitTake") int limitTake, 
			@Param("searchKeyword") String searchKeyword,@Param("searchKeywordTypeCode") String searchKeywordTypeCode);

	int getArticlesCount(@Param("boardId") int boardId);

	Article getArticleById(@Param("id") int id);

	Article getArticleByBoardId(@Param("boardid") int boardid);

	void modify(@Param("id") int id,@Param("body") String body);

	void increaseHit(@Param("id") int id);


}
