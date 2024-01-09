package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

// @Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
	// Spring date JPA
	
	// 기본 제공 메소드
	// Entity 객체 save(Entity 객체);
	// 1. Insert(ID가 Null)
	
	// 2. Update(ID가 있음)
	// Optional<Entity> findById(id)
	
	// 3. Delete(ID가 있음)
	// void delete(Entity 객체)
	
	// EX02 - 1
	// 조회하는 여러 가지 방법
	// 1. List<Entity 객체> findAll();
	
	// 제공되지 않는 메소드 - JPQL
	// 2. 'id' 기준 내림차순 전제 조회
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	// 3. 'id' 기준 내림차순 3개만 조회
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// 4. 이름 '김바다' 조회
	public List<StudentEntity> findByName(String name);
	
	// 5. 'in'문으로 일치하는 값 모두 조회(이름)
	public List<StudentEntity> findByNameIn(List<String> names);
	
	// 6. 여러 컬럼값과 일치하는 데이터 조회(이름, 장래희망)
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	// 7. email 컬럼에 naver 키워드가 포함된 데이터 조회(like문 - %naver%)
	public List<StudentEntity> findByEmailContaining(String email);
	
	// 8. 이름이 '김'으로 시작하는 데이터 조회(like문 - 김%)
	public List<StudentEntity> findByNameStartingWith(String name);
	
	// 9. 'id'가 1 ~ 5인 데이터 조회(between)
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// EX02 - 2 - JPQL(Entity에 조회)
	// 엄밀히 말하면 entity에 조회하는 것
	// @Param - ibatis가 아닌 것으로 선택
	// @Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL 문법
	
	// 직접 DB를 조회한다. 
	@Query(value = "select * from new_student where dreamJob =:dreamJob", nativeQuery = true) // nativeQuery - SQL문 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
} // public interface StudentRepository