package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {

	// input : 파라미터들
	// output : X
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	// input : X
	// output : User(있거나 or null)
	public User selectLatestUser();
	
	// Lesson06Ex02
	// input : name / output : boolean(true - 중복, false - 중복 X)
	// '0'이면 거짓, '0이 아닌 수'면 참 (count함수 사용)
	public boolean isDuplicationByName(String name);
	
} // public interface UserMapper