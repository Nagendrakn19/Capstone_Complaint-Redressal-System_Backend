package com.comviva.webservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="role")
	private String role;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="users_tkts", joinColumns=@JoinColumn(name="id"),
	inverseJoinColumns=@JoinColumn(name="tkt_id"))
	private List<Ticket> tickets;

	public User() {
		super();
	}

	public User(long id, String name, String email, String password, String address, String pincode, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.pincode = pincode;
		this.role = role;
	}

	public User(String name, String email, String password, String address, String pincode, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.pincode = pincode;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}	
