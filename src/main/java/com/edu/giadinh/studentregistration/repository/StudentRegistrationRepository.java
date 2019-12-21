package com.edu.giadinh.studentregistration.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.giadinh.studentregistration.model.StudentRegistration;

@Repository
public interface StudentRegistrationRepository extends MongoRepository<StudentRegistration, String> {

	StudentRegistration findByEmail(String email);
	List<StudentRegistration> findCustomByEmail(String email);
//
//	Student findById(Long id);
//
	//JSON query string
	@Query("{fullName:'?0'}")
	List<StudentRegistration> findEmailByName(String fullName);

}
