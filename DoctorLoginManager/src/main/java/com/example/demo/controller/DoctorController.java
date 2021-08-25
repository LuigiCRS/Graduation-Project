package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping(path = "/api/doctor")
public class DoctorController {
	
	private final DoctorService doctorService;
	
	@Autowired
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@PostMapping("/registration")
	public String postNewDoctor(@RequestBody Doctor doctor) {
		System.out.println(doctor.toString());
		doctorService.createDoctor(doctor);
		return "done.";
		
	}
	
	@GetMapping("/findByEmail/{email}")
	public Doctor readDoctorByEmail(@PathVariable String email) {
		return doctorService.getDoctorByEmail(email);
	}
	
	
	@GetMapping("/login/{email}/{password}")
	public Doctor readDoctorByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return doctorService.getDoctorByEmailAndPassword(email, password);
	}
}
