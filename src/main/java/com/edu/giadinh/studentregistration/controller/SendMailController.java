package com.edu.giadinh.studentregistration.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.giadinh.studentregistration.dto.SendMailDto;
import com.edu.giadinh.studentregistration.model.Mail;
import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.service.EmailService;
import com.edu.giadinh.studentregistration.service.StudentRegistrationService;

@Controller
@RequestMapping("/xemHoSo")
public class SendMailController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;

	@Autowired
	private EmailService emailService;


	@ModelAttribute("xemHoSoForm")
	public SendMailDto sendMailDto() {
		return new SendMailDto();
	}

	@GetMapping
	public String displayXemHoSo() {
		return "xemHoSo";
	}

//	@PostMapping
//	public String processXemHoSo(@Valid StudentRegistration form,BindingResult result, HttpServletRequest request) {
//		StudentRegistration stu = studentRegistrationService.findByEmail(form.getEmail());
//		if (stu == null) {
//			result.rejectValue("email", null, "We could not find an account for that e-mail address.");
//			return "xemHoSo";
//		}
//		Mail mail = new Mail();
//		mail.setFrom("user1@testmail.com");
//		mail.setTo(stu.getEmail());
//		mail.setSubject("Hello");
//
//		Map<String, Object> model = new HashMap<>();
//		model.put("stu", stu);
//		model.put("signature", "http://localhost:8070");
//		mail.setModel(model);
//		emailService.sendEmail(mail);
//		return "redirect:/xemHoSo?success";
//	}

	@PostMapping
	public String processXemHoSo(@Valid StudentRegistration form) {
		StudentRegistration stu = studentRegistrationService.findByEmail(form.getEmail());
		
		return "";
	}

}
