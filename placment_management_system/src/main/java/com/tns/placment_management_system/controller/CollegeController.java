package com.tns.placment_management_system.controller;

import java.util.List;

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

import com.tns.placment_management_system.model.College;
import com.tns.placment_management_system.service.CollegeService;


@RestController
public class CollegeController {
	@Autowired
	private CollegeService service;
	
	@GetMapping("/helloCollege")
	public String hello() {
		return "hello running successful";
	}
	
	@GetMapping("/displayCollege")
	public List<College> display(){
		return service.display();
	}
	
	@DeleteMapping("/deleteCollegeById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean b = service.deleteById(id);
		if(b) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("deletion unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/insertCollege")
	public ResponseEntity<String> insert(@RequestBody College college) {
		boolean b = service.insert(college);
		if(b) {
			return new ResponseEntity<String>("Inserted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Insertion unsuccessfull check for datavariable or its name matching",HttpStatus.EXPECTATION_FAILED);
		}
	} 
	
	@PutMapping("/updateCollegeById/{id}")
	public ResponseEntity<String> deleteById(@RequestBody College newuser,@PathVariable Long id) {
		
		try {
		College olduser=service.searchById(id);
		olduser.setCollegeAdmin(newuser.getCollegeAdmin());
		olduser.setCollegeName(newuser.getCollegeName());
		olduser.setLocation(newuser.getLocation());
		service.insert(olduser);
			return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("updation unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
}
