package com.comviva.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.webservice.model.Ticket;
import com.comviva.webservice.repository.TicketRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketContoller {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping("/tickets")
	public List<Ticket> getTickets(){
		return ticketRepository.findAll();
	}
	
	@GetMapping("/tickets/{id}")
	public Ticket getTicket(@PathVariable long id) {
		return ticketRepository.findById(id).get();
	}
	
	@PutMapping("/tickets/{id}")
	public Ticket updateTicket(@PathVariable long id,@RequestBody String status) {
		Ticket tkt = ticketRepository.findById(id).get();
		tkt.setStatus(status);
		return ticketRepository.save(tkt);
	}
}
