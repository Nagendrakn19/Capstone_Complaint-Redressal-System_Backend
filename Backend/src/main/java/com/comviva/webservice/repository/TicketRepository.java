package com.comviva.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comviva.webservice.model.Ticket; 

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
