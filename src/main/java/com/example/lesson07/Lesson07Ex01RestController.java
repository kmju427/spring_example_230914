package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C : Create
	// http://localhost/lesson07/ex01/1
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "신짱구";
		String phoneNumber = "010-5876-3882";
		String email = "zzang@google.com";
		String dreamJob = "액션가면";
		
		// 방금 Insert된 pk id도 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U : Update
	// http://localhost/lesson07/ex01/2
	@GetMapping("/2")
	public StudentEntity update() {
		// 'id'가 5번인 dreamJob 변경
		// 5, 의사
		return studentBO.updateStudentDreamJobById(5, "의사");
	}
	
	// D : Delete
	// http://localhost/lesson07/ex01/3
	@GetMapping("/3")
	public String delete() {
		// 'id'가 6번인 것 삭제
		studentBO.deleteStudentById(6);
		
		return "삭제 완료";
	}
	
} // public class Lesson07Ex01RestController