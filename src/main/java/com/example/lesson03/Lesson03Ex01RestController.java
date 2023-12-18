package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// url : http://localhost/lesson03/ex01
	// url : http://localhost/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// required, dafaultValue를 표시해주지 않는 경우에는 value를 적지 않아도 된다.
			// @RequestParam(value = "id") int id // 필수 파라미터
			// @RequestParam(value = "id", required = true) int id // 필수 파라미터
			// @RequestParam(value = "id", required = false) Integer id // 비필수 파라미터
			// @RequestParam(value = "id", defaultValue = "1") int id // 비필수 파라미터
			@RequestParam("id") int id) { // 필수 파라미터
		
//		if (id == null) { // 컨트롤러는 비필수 파라미터로 넘기지만 BO에서 필수 파라미터로 받는다고 설정해서 에러가 발생하는 경우
//			id = 1;
//		}
		return reviewBO.getReview(id); // response JSON
	}
	
} // public class Lesson03Ex01RestController