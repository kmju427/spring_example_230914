package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.User;

@Repository
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
	
} // public interface UserMapper