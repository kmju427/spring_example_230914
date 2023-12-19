package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	// input : id
	// output : Review
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input : Review
	// output : X or 성공한 행의 개수(int)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// input : addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛있다!")
	// output : X or 성공한 행의 개수(int)
	// BO와 Mapper의 변수명은 아무 상관 없다. 서로 달라도 아무런 문제되지 않는다.
	// 컨트롤러에서 넘어오는 변수의 순서는 제대로 맞춰야 한다.
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input : id, review
	// output : 성공한 행의 개수
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
} // public class ReviewBO