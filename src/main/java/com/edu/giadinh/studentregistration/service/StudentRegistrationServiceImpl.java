package com.edu.giadinh.studentregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.repository.StudentRegistrationRepository;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;

	@Override
	public StudentRegistration save(StudentRegistration student) {
		StudentRegistration stu = new StudentRegistration();

		// Thông tin hộ khẩu
		stu.setStudentCode(student.getStudentCode());
		stu.setFullName(student.getFullName());
		stu.setPlaceOfBirth(student.getPlaceOfBirth());
		stu.setIdOfStudent(student.getIdOfStudent());
		stu.setPhoneNumber(student.getPhoneNumber());
		stu.setDateOfBirth(student.getDateOfBirth());
		stu.setEmail(student.getEmail());
		if(student.getGender().equals("Nam"))
		{
			stu.setGender("Nam");
		}else {
			stu.setGender("Nữ");
		}
		stu.setAreaCode(student.getAreaCode());
		stu.setMajorRegistration(student.getMajorRegistration());
		// Thông tin hộ khẩu
		stu.setAddress(student.getAddress());
		stu.setSubDistrict(student.getSubDistrict());
		stu.setDistrict(student.getDistrict());
		stu.setProvince(student.getProvince());
		// Thông tin phụ huynh
		stu.setNameOfFather(student.getNameOfFather());
		stu.setPhoneNumberOfFather(student.getPhoneNumberOfFather());
		stu.setNameOfMother(student.getNameOfMother());
		stu.setPhoneNumberOfMother(student.getPhoneNumberOfMother());
		// Điểm học bạ
		stu.setMathScoresInSchoolReport(student.getMathScoresInSchoolReport());
		stu.setChemistryScoresInSchoolReport(student.getChemistryScoresInSchoolReport());
		stu.setPhysicsScoresInSchoolReport(student.getPhysicsScoresInSchoolReport());
		stu.setLiteraryScoresInSchoolReport(student.getLiteraryScoresInSchoolReport());
		// Điểm thi tốt nghiệp
		stu.setMathScoresOfGraduationTest(student.getMathScoresOfGraduationTest());
		stu.setChemistryScoresOfGraduationTest(student.getChemistryScoresOfGraduationTest());
		stu.setPhysicsScoresOfGraduationTest(student.getPhysicsScoresOfGraduationTest());
		stu.setLiteraryScoresOfGraduationTest(student.getLiteraryScoresOfGraduationTest());
		// Thông tin trường cấp 3
		stu.setAddressSchool(student.getAddressSchool());
		stu.setDistrictSchool(student.getDistrictSchool());
		stu.setSubDistrictSchool(student.getSubDistrictSchool());
		stu.setProvinceSchool(student.getProvinceSchool());
		// Thông tin thêm
		stu.setAddressNow(student.getAddressNow());
		stu.setNotes(student.getNotes());
		stu.setStatus(student.getStatus());
		return studentRegistrationRepository.save(stu);
	}

	@Override
	public List<StudentRegistration> findAll() {
		return studentRegistrationRepository.findAll();
	}

//	@Override
//	public List<Student> insert(Student student) {
//		return (List<Student>) studentRepository.insert(student);
//	}

	@Override
	public List<StudentRegistration> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentRegistration> findStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentRegistration findByEmail(String email) {
		return studentRegistrationRepository.findByEmail(email);
	}

}
