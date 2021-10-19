package com.mjh.exam.projoect1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Article;

@Mapper
public interface ArticleDao {

	Article list();

	Article showdetail(@Param("title") String title,@Param("body") String body);

	void write(@Param("title") String title, @Param("body") String body);

	void deleteArticle(@Param("id") int id);

	void modify(@Param("id") int id, @Param("title") String title,@Param("body") String body);

}
