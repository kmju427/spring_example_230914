package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input : id
	// output : Review
	public Review selectReview(int id);
	
	// input : Review
	// output : X or 성공한 행의 개수(int)
	public int insertReview(Review review);
	
	// input : addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛있다!")
	// output : X or 성공한 행의 개수(int)
	public int insertReviewAsField(
			// 하나의 map이 된 것 -> @Param
			// .xml에서는 변수명이 아닌 키명으로 매핑된다.
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	// input : id, review
	// output : 성공한 행의 개수
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
} // public interface ReviewMapper