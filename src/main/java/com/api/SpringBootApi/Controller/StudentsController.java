package com.api.SpringBootApi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SpringBootApi.Model.Students;
import com.api.SpringBootApi.Service.StudentsService;


@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

	private final StudentsService studentsService;
	
	@Autowired
	public StudentsController(StudentsService studentsService) {
		this.studentsService =  studentsService;
	}
	
	@GetMapping
	public List<Students> getStudents(){
		return studentsService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Students student) {
		studentsService.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentsService.deleteStudent(studentId);
	}
}
