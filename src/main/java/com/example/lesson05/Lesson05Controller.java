package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	// http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	// http://localhost/lesson05/ex02
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = List.of("사과", "딸기", "바나나", "수박", "배");
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김민주");
		user.put("age", 31);
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 35);
		users.add(user);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
} // public class Lesson05Controller