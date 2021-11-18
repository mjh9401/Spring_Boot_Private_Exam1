package com.mjh.exam.projoect1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Board;

@Mapper
public interface BoardDao {

	Board getBoardById(@Param("boardId") int boardId);

}
