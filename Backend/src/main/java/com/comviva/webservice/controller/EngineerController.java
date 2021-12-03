package com.comviva.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.webservice.model.Ticket;
import com.comviva.webservice.model.User;
import com.comviva.webservice.repository.AdminUserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EngineerController {
	
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@GetMapping("/engineer/{pincode}")
	public List<User> getEngineers(@PathVariable String pincode){
		return adminUserRepository.getEngineers(pincode);
	}
	
	@PostMapping("/engineer/{id}")
	public User addTicket(@PathVariable long id,@RequestBody Ticket ticket) { 
		ticket.setDate(java.util.Calendar.getInstance().getTime());
		User user = adminUserRepository.findById(id).get();
		ticket.setPincode(user.getPincode());
		ticket.setStatus("Assigned");
		user.getTickets().add(ticket);
		return adminUserRepository.save(user);
	}
}
