package com.mjh.exam.projoect1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Member;

@Mapper
public interface MemberDao {

	void doJoin(@Param("loginId") String loginId,@Param("loginPassWord") String loginPassWord, 
			@Param("name") String name,@Param("nickName") String nickName, 
			@Param("cellphonNO") String cellphonNO, @Param("email") String email);

	Member search(@Param("name") String name,@Param("email") String email);

	void modify(@Param("id") int id, @Param("name") String name,@Param("nickName") String nickName,
			@Param("cellphonNo") String cellphonNo,@Param("email") String email);

	void delete(@Param("id") int id);

}
