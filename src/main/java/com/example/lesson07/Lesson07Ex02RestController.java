package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// 이번에만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 여러 가지 방법
	// http://localhost/lesson07/ex02/1
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1. 전체 조회(기본 제공 메소드)
		// return studentRepository.findAll();
		
		// 제공되지 않는 메소드 - JPQL
		// 2. 'id' 기준 내림차순 전제 조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3. 'id' 기준 내림차순 3개만 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. 이름 '김바다' 조회
		// return studentRepository.findByName("김바다");
		
		// 5. 'in'문으로 일치하는 값 모두 조회(이름)
		// return studentRepository.findByNameIn(Arrays.asList("유재석", "조세호", "신짱구"));
		
		// 6. 여러 컬럼값과 일치하는 데이터 조회(이름, 장래희망)
		// return studentRepository.findByNameAndDreamJob("김바다", "판사");
		
		// 7. email 컬럼에 naver 키워드가 포함된 데이터 조회(like문 - %naver%)
		// Contains, Containing
		// return studentRepository.findByEmailContaining("naver");
		
		// 8. 이름이 '김'으로 시작하는 데이터 조회(like문 - 김%)
		// return studentRepository.findByNameStartingWith("김");
		
		// 9. 'id'가 1 ~ 5인 데이터 조회(between)
		return studentRepository.findByIdBetween(1, 5);
	}
	
	// http://localhost/lesson07/ex02/2
	@GetMapping("/2")
	public List<StudentEntity> getStudent() {
		// 장래희망이 '변호사'인 데이터 조회
		return studentRepository.findByDreamJob("변호사");
	}
	
} // public class Lesson07Ex02RestController