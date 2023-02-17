package com.tns.placment_management_system.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.model.Student;
import com.tns.placment_management_system.repo.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student searchStudentById(Long id) {
		return repo.findById(id).get();
	}
	
	public void save(Student s)
	{
		repo.save(s);
	}
	
	public Student get(Long id)
	{
		return repo.findById(id).get();
	}
	
	public List<Student> display(){
		return repo.findAll();
	}
	
	public Student searchStudentByHallticket(Long hallticket) {
		Long id = repo.searchStudentByHallticket(hallticket);
		return repo.findById(id).get();
	}
	public Boolean deleteStudentByIds(Long Id) {
		Boolean b=false;
		try {
			repo.deleteById(Id);
			b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
