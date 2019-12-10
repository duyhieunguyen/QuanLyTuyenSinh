package com.edu.giadinh.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edu.giadinh.user.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByEmail(String email);

}
