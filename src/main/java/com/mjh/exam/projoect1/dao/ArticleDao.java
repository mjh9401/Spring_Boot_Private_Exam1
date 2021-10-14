package com.mjh.exam.projoect1.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mjh.exam.projoect1.vo.Article;

@Mapper
public interface ArticleDao {

	Article list();

}
