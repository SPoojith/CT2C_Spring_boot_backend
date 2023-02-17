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

import com.tns.placment_management_system.model.Certificate;
import com.tns.placment_management_system.service.CertificateService;


@RestController

public class CertificateController {
	
	@Autowired
	private CertificateService service;
	
	@GetMapping("/helloCertificate")
	public String hello() {
		return "hello running successful";
	}
	
	@GetMapping("/displayCertificate")
	public List<Certificate> display(){
		return service.display();
	}
	
	@DeleteMapping("/deleteCertificateById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean b = service.deleteById(id);
		if(b) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("deletion unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/insertCertificate")
	public ResponseEntity<String> insert(@RequestBody Certificate certificate) {
		boolean b = service.insert(certificate);
		if(b) {
			return new ResponseEntity<String>("Inserted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Insertion unsuccessfull check for datavariable or its name matching",HttpStatus.EXPECTATION_FAILED);
		}
	} 
	
	@PutMapping("/updateCertificateById/{id}")
	public ResponseEntity<String> deleteById(@RequestBody Certificate newuser,@PathVariable Long id) {
		
		try {
		Certificate olduser=service.searchById(id);
		olduser.setCollege(newuser.getCollege());
		olduser.setYear(newuser.getYear());
		service.insert(olduser);
			return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("updation unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	

}
