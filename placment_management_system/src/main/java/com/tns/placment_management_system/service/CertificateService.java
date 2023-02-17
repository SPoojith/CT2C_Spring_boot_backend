package com.tns.placment_management_system.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.model.Certificate;
import com.tns.placment_management_system.repo.CertificateRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CertificateService {
	@Autowired
	private CertificateRepo repo;
	
	public List<Certificate> display(){
		return repo.findAll();
	}
	
	public Certificate searchById(Long Id) {
		return repo.findById(Id).get();
	}
	
	public boolean deleteById(Long Id) {
		try {
			repo.deleteById(Id);
			return true;
		}
		catch (Exception e) {
			return false;	
		}
	}
	
	public boolean insert(Certificate certificate) {
		try {
			repo.save(certificate);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
}
