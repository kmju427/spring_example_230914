package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring Bean(객체)으로 등록
@RequestMapping("/lesson01/ex01") // 공통되는 path 부분을 빼낼 수도 있다. 메소드 위에 붙은 패스보다 먼저 읽혀진다.
public class Lesson01Ex01Controller {

	// String을 브라우저에 출력
	// url : http://localhost/lesson01/ex01/1
	@RequestMapping("/1")
	@ResponseBody // 리턴되는 값을 Response Body에 넣어서 보낸다. -> HTML
	public String ex01_1() {
		return "<h2>예제 1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// Map 출력 -> JSON String 출력
	// url : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() { // 이렇게 할 수도 있다라고만 생각, 메소드 위에 쓰는게 일반적
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 4);
		map.put("파인애플", 32);
		map.put("블루베리", 10);
		map.put("코코넛", 4);
		
		// map을 리턴하면 json으로 나타난다.
		// web starter에 jackson 라이브러리가 포함되어 있기 때문
		return map;
	}
	
} // public class Lesson01Ex01Controller