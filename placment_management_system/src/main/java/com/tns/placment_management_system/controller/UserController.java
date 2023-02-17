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

import com.tns.placment_management_system.Exceptions.NoUserException;
import com.tns.placment_management_system.Exceptions.WrongPassword;
import com.tns.placment_management_system.model.Login;
import com.tns.placment_management_system.model.User;
import com.tns.placment_management_system.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/helloUser")
	public String hello() {
		return "hello running successful";
	}
	
	@GetMapping("/displayUser")
	public List<User> display(){
		return service.display();
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		boolean b = service.deleteById(id);
		if(b) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("deletion unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/insertUser")
	public ResponseEntity<String> insert(@RequestBody User user) {
		boolean b = service.insert(user);
		if(b) {
			return new ResponseEntity<String>("Inserted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Insertion unsuccessfull check for datavariable or its name matching",HttpStatus.EXPECTATION_FAILED);
		}
	} 
	
	@PutMapping("/updateUserById/{id}")
	public ResponseEntity<String> deleteById(@RequestBody User newuser,@PathVariable Long id) {
		
		try {
		User olduser=service.searchById(id);
		olduser.setName(newuser.getName());
		olduser.setPassword(newuser.getPassword());
		olduser.setType(newuser.getType());
		service.insert(olduser);
			return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("updation unsuccessfull either enter correct id or data not present",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login login) {
		try {
			User user = service.login(login.getUsername(), login.getPassword());
			return new ResponseEntity<String>("right unser name right password \n"+user,HttpStatus.BAD_GATEWAY);
		}catch(NoUserException e) {
			System.out.println(e);
			System.out.println("came to controller nouser password");
			return new ResponseEntity<String>(e+"\nlogin unsuccessfull wrong username",HttpStatus.LOCKED);
		}catch(WrongPassword e) {
			System.out.println(e);
			System.out.println("came to controller wrong password");
			return new ResponseEntity<String>(e+"\nlogin unsuccessfull right username but wrong password",HttpStatus.LOCKED);
		}
		catch (Exception e) {
			System.out.print("came to controller exception");
			return new ResponseEntity<String>("\nlogin unsuccessfull its not u tryagain",HttpStatus.BAD_REQUEST);
		}
	}

}
