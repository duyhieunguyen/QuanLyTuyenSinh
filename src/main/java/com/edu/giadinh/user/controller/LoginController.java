package com.edu.giadinh.user.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.giadinh.user.model.Student;
import com.edu.giadinh.user.service.CustomStudentDetailsService;
@Controller
public class LoginController {
	
	@Autowired
	private CustomStudentDetailsService studentService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
	    ModelAndView modelAndView = new ModelAndView();
	    Student student = new Student();
	    modelAndView.addObject("student", student);
	    modelAndView.setViewName("signup");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Student student, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    Student studentExists = studentService.findUserByEmail(student.getEmail());
	    if (studentExists != null) {
	        bindingResult
	                .rejectValue("email", "error.user",
	                        "There is already a user registered with the username provided");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("signup");
	    } else {
	        studentService.saveStudent(student);
	        modelAndView.addObject("successMessage", "User has been registered successfully");
	        modelAndView.addObject("student", new Student());
	        modelAndView.setViewName("login");

	    }
	    return modelAndView;
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
	    ModelAndView modelAndView = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Student student = studentService.findUserByEmail(auth.getName());
	    modelAndView.addObject("currentUser", student);
	    modelAndView.addObject("fullName", "Welcome " + student.getFullname());
	    modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
	    modelAndView.setViewName("dashboard");
	    return modelAndView;
	}
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
}