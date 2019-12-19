package com.edu.giadinh.studentregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.giadinh.studentregistration.model.StudentRegistration;

@Service
public interface StudentRegistrationService {
	StudentRegistration save(StudentRegistration student);

	List<StudentRegistration> findAll();
	StudentRegistration findByEmail(String email);

	List<StudentRegistration> findStudentByName(String name);
	
//	List<Student> insert(Student student);

	List<StudentRegistration> findStudentById(Long id);
}
