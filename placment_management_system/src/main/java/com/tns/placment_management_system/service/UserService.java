package com.tns.placment_management_system.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placment_management_system.Exceptions.NoUserException;
import com.tns.placment_management_system.Exceptions.WrongPassword;
import com.tns.placment_management_system.model.User;
import com.tns.placment_management_system.repo.UserRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional

public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public List<User> display(){
		return repo.findAll();
	}
	
	public User searchById(Long Id) {
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
	
	public boolean insert(User user) {
		try {
			repo.save(user);
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
	
	public User login(String username,String password) throws NoUserException,WrongPassword{
			
			List<User> data=repo.findAll();
			for(User u:data) {
				
				if(u.getName().equals(username)){
					System.out.println("username"+username);
					System.out.println(u.getName());
					System.out.println("username"+username);
					if(u.getPassword().equals(password)) {
						System.out.println("username"+username);
						System.out.println(u.getPassword());
						System.out.println("Password"+password);
						return u;
					}else {
						System.out.println("will throw error wrong pass");
						throw new WrongPassword();
					}
				}
			}
			System.out.println("will throw error no user exception");
			throw new NoUserException();
			
	}
	
	public boolean logout() {
		return true;
	}
	
}
