package com.tns.placment_management_system.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placment_management_system.model.Student;
import com.tns.placment_management_system.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/helloStudent")
	public String hello() {
		return "hi poo";
	}
	
	@GetMapping("/displayStudents")
	public List<Student> display(){
		return service.display();
	}
	
	@GetMapping("/searchStudentById/{id}")
	public ResponseEntity<Student> searchStudentById(@PathVariable Long id){
		try {
			Student s = service.searchStudentById(id);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
			}		
	}
	
	@GetMapping("/searchStudentByHallticket/{hallticket}")
	public ResponseEntity<Student> searchStudentByHallticket(@PathVariable Long hallticket){
		try {
		Student s = service.searchStudentByHallticket(hallticket);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/deleteStudentById/{Id}")
	public String deleteStudentById(@PathVariable Long Id) {
		Boolean b=service.deleteStudentByIds(Id);
		if(b==true) {
			return "Successfully deleted good job Poojith";	
		}
		return "nope badluck maum try again";
	}

	@PostMapping("/insertStudent")
	public String addStudent(@RequestBody Student s)
	{
		service.save(s);
		return "successfull inserted "+" to check visit localhost:8081/display";
	}
	
	// RESTful API method for Update operation
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student newStudent, @PathVariable Long id)
	{
		try
		{
			Student oldStudent = service.get(id);
			oldStudent.setName(newStudent.getName());
			oldStudent.setCollege(newStudent.getCollege());
			oldStudent.setQualification(newStudent.getQualification());
			oldStudent.setCourse(newStudent.getCourse());
			oldStudent.setCertificate(newStudent.getCertificate());
			oldStudent.setYear(newStudent.getYear());
			oldStudent.setRoll(newStudent.getRoll());
			oldStudent.setHallTicketNo(newStudent.getHallTicketNo());
			service.save(oldStudent);
			/*service.deleteStudentByIds(oldStudent.getId());
			service.save(newStudent);
			Student s=service.get(newStudent.getId());*/
			return new ResponseEntity<Student>(oldStudent,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<String>("id not found",HttpStatus.BAD_REQUEST);
		}catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
