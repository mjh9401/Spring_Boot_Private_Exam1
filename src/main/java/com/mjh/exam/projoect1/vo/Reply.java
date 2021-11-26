package com.mjh.exam.projoect1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	private int id;
	private String regDate;
	private String updateDate;
	private String body;
	private int articleId;
	private int memberId;
	private int boardId;
	
	private String nickName;
}
