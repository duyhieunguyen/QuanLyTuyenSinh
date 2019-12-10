package com.edu.giadinh.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edu.giadinh.user.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
