package com.edu.giadinh.studentregistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edu.giadinh.studentregistration.model.StudentRegistration;

@Repository
public interface StudentRegistrationRepository extends MongoRepository<StudentRegistration, String> {

	StudentRegistration findByEmail(String email);
//	List<Student> findStudentByName(String name);
//
//	Student findById(Long id);
//
//	//JSON query string
//	@Query("{fullName:'?0'}")
//	List<Student> findCustomByFullName(String fullName);

}
