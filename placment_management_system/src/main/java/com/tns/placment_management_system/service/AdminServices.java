package com.tns.placment_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.model.Admin;

import com.tns.placment_management_system.repo.AdminRepo;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServices {
	@Autowired
	private AdminRepo repo;
	
	public List<Admin> displayAdmin(){
		return repo.findAll();
	}
	
	public Admin searchAdminById(Long Id) {
		return repo.findById(Id).get();
	}
	
	public boolean deleteAdminById(Long Id) {
		try {
			repo.deleteById(Id);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
	
	public boolean insertAdmin(Admin admin) {
		try {
			repo.save(admin);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
}
