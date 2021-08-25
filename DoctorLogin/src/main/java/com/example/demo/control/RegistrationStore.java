package com.example.demo.control;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Doctor;


public class RegistrationStore{
	
	
	public String putRequest(Doctor doctor) {
			String url = "http://localhost:8081/api/doctor/registration";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			Doctor newDoctor = new Doctor(doctor);
			HttpEntity<Doctor> request = new HttpEntity<>(newDoctor, headers);
			@SuppressWarnings("unused")
			ResponseEntity<String> resposeEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			return "done.";
		}
	
	public boolean dataValidation(String email) {
		String url = "http://localhost:8081/api/doctor/findByEmail/" + email;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<Doctor> resposeEntity = restTemplate.exchange(
																url, 
																HttpMethod.GET, 
																request, 
																Doctor.class
																);
		Doctor doctors = resposeEntity.getBody();
		if(doctors != null ) {
			return false;
		}
		return true;
	}

}
