package com.example.demo.control;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Batch;

public class BatchControl {

	public void registration(Batch batch) {
		String url = "http://localhost:8084/api/bath/registration";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Batch> request = new HttpEntity<>(batch, headers);
		@SuppressWarnings("unused")
		ResponseEntity<Batch> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, request, Batch.class);
		
	}

	public List<Batch> todayDosesList(String date) {
		String url = "http://localhost:8084/api/batch/getByDate/" + date;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<List<Batch>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, 
				new ParameterizedTypeReference<List<Batch>>() {} 
		);
		return responseEntity.getBody();
	}

	public List<Batch> todayDosesByOharmaceuticalCompany(String pC) {
		String url = "http://localhost:8084/api/batch/getByPharmaceuticalCompany/" + pC;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<List<Batch>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, 
				new ParameterizedTypeReference<List<Batch>>() {} 
		);
		return responseEntity.getBody();
	}

}
