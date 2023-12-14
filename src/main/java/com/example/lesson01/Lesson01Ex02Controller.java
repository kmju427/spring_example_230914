package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안 된다!(@RestController도 마찬가지)
public class Lesson01Ex02Controller {

	// url : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request path 주소
	public String ex02() { // String으로 해야한다. return하는 주소가 ""에 묶여 있는데 자바에서는 "" -> String 타입이기 때문
		// return 되는 String은 jsp의 경로이다. (@ResponseBody가 없을 때)
		// return "/WEB-INF/jsp/lesson01/ex02.jsp"; -> 편의성을 위한 설정을 하지 않았을 때 경로를 다 적어줘야 한다.
		return "lesson01/ex02"; // Response view 경로
	}
	
} // public class Lesson01Ex03Controller