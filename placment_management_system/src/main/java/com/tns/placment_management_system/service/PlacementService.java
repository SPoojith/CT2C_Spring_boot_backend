package com.tns.placment_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.model.Placement;
import com.tns.placment_management_system.repo.PlacementRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlacementService {
	@Autowired
	private PlacementRepo repo;
	
	public List<Placement> display(){
		return repo.findAll();
	}
	
	public Placement searchById(Long Id) {
		return repo.findById(Id).get();
	}
	
	public boolean deleteById(Long Id) {
		try {
			repo.deleteById(Id);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
	
	public boolean insert(Placement placement) {
		try {
			repo.save(placement);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}

}
