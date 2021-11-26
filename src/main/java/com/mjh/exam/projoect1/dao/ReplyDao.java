package com.mjh.exam.projoect1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Reply;

@Mapper
public interface ReplyDao {

	void doWrite(@Param("articleId") int articleId,@Param("memberId") int memberId,
			@Param("boardId") int boardId, @Param("body") String body);

	List<Reply> getForPrintReplies(@Param("boardId") int boardId,@Param("articleId") int articleId,@Param("memberId") int memberId);

}
