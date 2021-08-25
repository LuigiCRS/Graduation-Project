package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private final DoctorRepository doctorReposiory;
	
	@Autowired
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorReposiory = doctorRepository;
	}
	
	public Doctor createDoctor(Doctor newDoctor) {
		return doctorReposiory.save(newDoctor);
	}
	
	public Doctor getDoctorByEmail(String email) {
		return doctorReposiory.findByEmail(email);
	}
	
	public Doctor getDoctorByEmailAndPassword(String email, String password) {
		return doctorReposiory.findByEmailAndPassword(email, password);
	}
}
