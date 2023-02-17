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

import com.tns.placment_management_system.model.Placement;
import com.tns.placment_management_system.model.User;
import com.tns.placment_management_system.service.PlacementService;

@RestController
public class PlacementController {
	
	@Autowired
	private PlacementService service;
	
	@GetMapping("/helloPlacement")
	public String hello() {
		return "hello running successful";
	}
	
	@GetMapping("/displayPlacement")
	public List<Placement> display(){
		return service.display();
	}
	
	@DeleteMapping("/deletePlacementById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean b = service.deleteById(id);
		if(b) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("deletion unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/insertPlacement")
	public ResponseEntity<String> insert(@RequestBody Placement placement) {
		boolean b = service.insert(placement);
		if(b) {
			return new ResponseEntity<String>("Inserted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Insertion unsuccessfull check for datavariable or its name matching",HttpStatus.EXPECTATION_FAILED);
		}
	} 
	
	@PutMapping("/updatePlacementById/{id}")
	public ResponseEntity<String> deleteById(@RequestBody Placement newuser,@PathVariable Long id) {
		
		try {
		Placement olduser=service.searchById(id);
		olduser.setCollege(newuser.getCollege());
		olduser.setDate(newuser.getDate());
		olduser.setName(newuser.getName());
		olduser.setQualification(newuser.getQualification());
		olduser.setYear(newuser.getYear());
		service.insert(olduser);
			return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("updation unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}

}
