package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// Lesson07 - Ex01
	// JPA Insert
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// JPA Update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// select
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// update - save
		if (student != null) {
			student = student.toBuilder() // 기존 필드값들은 유지하고 일부 필드만 변경 - toBuilder()
						.dreamJob(dreamJob)
						.build(); // ★★★ 반드시 다시 저장해야 한다!!!
			
			// update
			student = studentRepository.save(student);
		}
		
		return student; // student or null
	}
	
	// JPA Delete
	public void deleteStudentById(int id) {
		// select
		// 방법 1
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// delete
		// Optional - null 검사 생략하기 위해 사용
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	// MyBatis Insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
} // public class StudentBO