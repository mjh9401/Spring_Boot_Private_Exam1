package com.mjh.exam.projoect1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.dao.ReplyDao;
import com.mjh.exam.projoect1.vo.Reply;

@Service
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;

	public void doWrite(int articleId, int memberId, int boardId, String body) {
		replyDao.doWrite(articleId,memberId,boardId,body);
	}

	public List<Reply> getForPrintReplies(int boardId, int articleId, int memberId) {
		
		return replyDao.getForPrintReplies(boardId,articleId,memberId);
	}
}
