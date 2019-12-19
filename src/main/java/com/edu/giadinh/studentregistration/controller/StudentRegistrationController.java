package com.edu.giadinh.studentregistration.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.giadinh.studentregistration.model.Mail;
import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.service.EmailService;
import com.edu.giadinh.studentregistration.service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/dangkytuyensinh", method = RequestMethod.GET)
	public ModelAndView dangKyTuyenSinh() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dangkytuyensinh");
		return modelAndView;
	}

	@RequestMapping(value = "/dangkytuyensinh", method = RequestMethod.POST)
	public ModelAndView dangKyTuyenSinh(StudentRegistration student) {
		ModelAndView modelAndView = new ModelAndView();
		studentRegistrationService.save(student);
		StudentRegistration stu = studentRegistrationService.findByEmail(student.getEmail());
		
		Mail mail = new Mail();
		mail.setFrom("user1@testmail.com");
		mail.setTo(stu.getEmail());
		mail.setSubject("[GDU]-ĐH Gia Định");

		Map<String, Object> model = new HashMap<>();
		model.put("stu", stu);
		model.put("signature", "http://localhost:8070");
		mail.setModel(model);
		emailService.sendEmail(mail);
		modelAndView.setViewName("index");
		
		return modelAndView;
	}

//	@RequestMapping(value = "/xemhoso", method = RequestMethod.GET)
//	public ModelAndView xemHoSo() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("xemhoso");
//		return modelAndView;
//	}
}
