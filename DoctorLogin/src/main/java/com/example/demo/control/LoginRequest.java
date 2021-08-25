package com.example.demo.control;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.User;

public class LoginRequest {

	
	public boolean dataValidation(String email, String password) {
		
		String url="http://localhost:8081/api/doctor/login/" + email + "/" + password;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(header);
		ResponseEntity<Doctor> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Doctor.class);
		this.doctor = responseEntity.getBody();
		if(doctor == null) {
			return false;
		} else if(doctor.getEmail().equals(email) && doctor.getPassword().equals(password)){
			return true;
		}
		return false;
		
	}
	
	
	public void authentication() {
		String url = "http://localhost:8082/api/user/run";
		User user = new User(this.doctor.getName(), this.doctor.getSurname());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> request = new HttpEntity<>(user, headers);
		@SuppressWarnings("unused")
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
		
		
	}
	
	private Doctor doctor = new Doctor();
	
}
