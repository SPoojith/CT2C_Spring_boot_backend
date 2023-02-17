package com.tns.placment_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placment_management_system.model.Admin;

import com.tns.placment_management_system.service.AdminServices;


@RestController
public class AdminController {
	@Autowired
	private AdminServices service;
	
	@GetMapping("/helloAdmin")
	public String hello() {
		return "hello running successful";
	}
	
	@GetMapping("/displayAdmin")
	public List<Admin> display(){
		return service.displayAdmin();
	}
	
	@DeleteMapping("/deleteAdminById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean b;
		try {
			b = service.deleteAdminById(id);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("some students records are dependent on this certificate",HttpStatus.EXPECTATION_FAILED);
		}
		if(b) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("deletion unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/insertAdmin")
	public ResponseEntity<String> insert(@RequestBody Admin admin) {
		boolean b = service.insertAdmin(admin);
		if(b) {
			return new ResponseEntity<String>("Inserted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Insertion unsuccessfull check for datavariable or its name matching",HttpStatus.EXPECTATION_FAILED);
		}
	}

}
