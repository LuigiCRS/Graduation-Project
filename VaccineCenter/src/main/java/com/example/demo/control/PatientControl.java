package com.example.demo.control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Batch;
import com.example.demo.entity.Confirm;
import com.example.demo.entity.Patient;
import com.example.demo.entity.User;

public class PatientControl {

	public Patient findByCf(String cf) {
		String url = "http://localhost:8083/api/patient/findByCf/" + cf;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<Patient> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Patient.class);
		return responseEntity.getBody();
	}
	
	public void deletePatient(String cf) {
		String url = "http://localhost:8083/api/patient/delete/" + cf;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		@SuppressWarnings("unused")
		ResponseEntity<Patient> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, request, Patient.class);
	}
	
	public List<Patient> todayPatientList(String date) {
		String url = "http://localhost:8083/api/patient/getByDate/" + date;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<List<Patient>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, 
				new ParameterizedTypeReference<List<Patient>>() {} 
		);
		return responseEntity.getBody();
	}

	public void updatePatient(Patient patient) {
		String url = "http://localhost:8083/api/patient/update";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Patient> request = new HttpEntity<>(patient, headers);
		@SuppressWarnings("unused")
		ResponseEntity<List<Patient>> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, request, 
				new ParameterizedTypeReference<List<Patient>>() {} 
		);
	}

	public void confirmVaccination(String cf, User user) {
		String url = "http://localhost:8084/api/batch/confirm";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<Batch> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Batch.class);
		System.out.println("**\n***\n****\nDOSE DONE\n*****\n****\n***\n**");
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String date = localDate.format(formatter).toString();
	    Date dateHour = new Date();
	    DateFormat format = new SimpleDateFormat("HH:mm");
	    String hour = format.format(dateHour);
		Confirm confirm = new Confirm(cf, responseEntity.getBody().getId(), date, hour, user.getName(), user.getSurname());
		String url2 = "http://localhost:8085/api/confirm";
		HttpEntity<Confirm> request2 = new HttpEntity<>(confirm, headers);
		@SuppressWarnings("unused")
		ResponseEntity<Confirm> responseEntity2 = restTemplate.exchange(url2, HttpMethod.POST, request2, Confirm.class);
		
	}
	
}
