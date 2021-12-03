package com.comviva.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comviva.webservice.model.Login;
import com.comviva.webservice.model.User;

public interface AdminUserRepository extends JpaRepository<User, Long> {
	@Query("Select u from User u where u.email = :#{#creds.email} and u.password = :#{#creds.password} and u.role = :#{#creds.role}")
	User findUser(@Param("creds") Login creds);
	
	@Query("Select u from User u where u.role='engineer' and u.pincode = :pincode")
	List<User> getEngineers(@Param("pincode") String pincode);
}