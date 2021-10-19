package com.mjh.exam.projoect1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	int id;
	String regDate;
	String updateDate;
	String loginId;
	String loginPassword;
	int authLevel;
	String name;
	String nickname;
	String cellphonNo;
	String email;
	boolean delStatus;
	String delDate;
}



