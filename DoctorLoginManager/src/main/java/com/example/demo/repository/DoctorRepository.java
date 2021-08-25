package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, String>{
	
	
	Doctor findByEmail(String email);
	
	
	Doctor findByEmailAndPassword(String email, String password);
	
}
