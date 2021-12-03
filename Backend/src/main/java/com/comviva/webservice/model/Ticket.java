package com.comviva.webservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tkt_id")
	private long id;
	
	@Column(name="descript")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="raised_by")
	private String raised_by;
    
	public Ticket(long id, String description, String status) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.date = java.util.Calendar.getInstance().getTime(); 
	}

	public Ticket(String description, String status) {
		super();
		this.description = description;
		this.status = status;
		this.date = java.util.Calendar.getInstance().getTime();
	}

	public Ticket() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRaised_by() {
		return raised_by;
	}

	public void setRaised_by(String raised_by) {
		this.raised_by = raised_by;
	}
	
	
	
}
