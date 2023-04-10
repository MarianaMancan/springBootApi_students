package com.api.SpringBootApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SpringBootApi.Model.Students;
import com.api.SpringBootApi.Repository.StudentsRepository;
@Service
public class StudentsService {

	private final StudentsRepository studentRepository;
	
	@Autowired
	private StudentsService(StudentsRepository studentsRepository) {
		this.studentRepository = studentsRepository;
	}
	
	
	
	public List<Students> getStudents() {
	  return studentRepository.findAll();
	}



	public void addNewStudent(Students student) {
	Optional<Students> studentByEmail =	studentRepository.findStudentByEmail(student.getEmail());
	
	if(studentByEmail.isPresent()) {
		throw new IllegalStateException("email already exists");
	}
	studentRepository.save(student);
	}



	public void deleteStudent(Long studentId) {
	boolean exists = studentRepository.existsById(studentId);
	if(!exists) {
		throw new IllegalStateException("student with id " + studentId + " does not exists");
	}
	studentRepository.deleteById(studentId);
	
	};
}
