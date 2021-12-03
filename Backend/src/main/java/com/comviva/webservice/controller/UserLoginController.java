package com.comviva.webservice.controller;

import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.webservice.model.Login;
import com.comviva.webservice.model.Ticket;
import com.comviva.webservice.model.User;
import com.comviva.webservice.repository.AdminUserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserLoginController {
	
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@PostMapping("/login")
	public User login(@RequestBody Login credentials) throws AuthenticationException {
		if(adminUserRepository.findUser(credentials) == null) {
			throw new AuthenticationException();
		}
		else {
			User user = adminUserRepository.findUser(credentials);
			return user;
		}
	}
	
	@GetMapping("/tickets/{id}")
	public List<Ticket> getTickets(@PathVariable long id){
		return adminUserRepository.findById(id).get().getTickets();
	}
	
	@PostMapping("tickets/{id}")
	public User addTicket(@PathVariable long id,@RequestBody Ticket ticket) { 
		ticket.setDate(java.util.Calendar.getInstance().getTime());
		User user = adminUserRepository.findById(id).get();
		ticket.setPincode(user.getPincode());
		ticket.setRaised_by(user.getName());
		user.getTickets().add(ticket);
		return adminUserRepository.save(user);
	}
}