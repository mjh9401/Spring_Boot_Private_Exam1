package com.mjh.exam.projoect1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.dao.BoardDao;
import com.mjh.exam.projoect1.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public Board getBoardById(int boardId) {
		return boardDao.getBoardById(boardId);
	}

}
