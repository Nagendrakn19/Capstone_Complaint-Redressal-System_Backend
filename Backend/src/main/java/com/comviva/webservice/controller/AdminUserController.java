package com.comviva.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.webservice.model.User;
import com.comviva.webservice.repository.AdminUserRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminUserController {
	
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return adminUserRepository.findAll(); 
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return adminUserRepository.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable long id) {
		return adminUserRepository.findById(id).get();	
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable long id,@RequestBody User user) {
		User u = adminUserRepository.findById(id).get();
		u.setName(user.getName());
		u.setAddress(user.getAddress());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setPincode(user.getPincode());
		u.setRole(user.getRole());
		
		return adminUserRepository.save(u);
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable long id) {
		User u = adminUserRepository.findById(id).get();
		adminUserRepository.delete(u);                                                                                                                                                                                                                                                                                                    
		return u;
	}
}
