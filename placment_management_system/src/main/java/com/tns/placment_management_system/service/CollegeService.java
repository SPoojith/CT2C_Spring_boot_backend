package com.tns.placment_management_system.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.model.College;
import com.tns.placment_management_system.repo.CollegeRepo;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollegeService {
	@Autowired
	private CollegeRepo repo;
	
	public List<College> display(){
		return repo.findAll();
	}
	
	public College searchById(Long Id) {
		return repo.findById(Id).get();
	}
	
	public boolean deleteById(Long Id){
		try {
			repo.deleteById(Id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean insert(College college) {
		try {
			repo.save(college);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}

}
