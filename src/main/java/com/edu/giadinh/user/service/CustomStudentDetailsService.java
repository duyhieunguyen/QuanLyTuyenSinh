package com.edu.giadinh.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edu.giadinh.user.model.Role;
import com.edu.giadinh.user.model.Student;
import com.edu.giadinh.user.repository.RoleRepository;
import com.edu.giadinh.user.repository.StudentRepository;

@Service
public class CustomStudentDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 Student student = studentRepository.findByEmail(email);
		    if(student != null) {
		        List<GrantedAuthority> authorities = getUserAuthority(student.getRoles());
		        return buildUserForAuthentication(student, authorities);
		    } else {
		        throw new UsernameNotFoundException("username not found");
		    }
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> studentRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    studentRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	public Student findUserByEmail(String email) {
	    return studentRepository.findByEmail(email);
	}
	
	public void saveStudent(Student student) {
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setEnabled(true);
	    Role studentRole = roleRepository.findByRole("ADMIN");
	    student.setRoles(new HashSet<>(Arrays.asList(studentRole)));
	    studentRepository.save(student);
	}
	
	private UserDetails buildUserForAuthentication(Student student, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), authorities);
	}
}