package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping(path = "/api/patient")
public class PatientController {

	
	private final PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	
	@GetMapping("/findByCf/{cf}")
	public Patient getPatientByCf(@PathVariable String cf) {
		return patientService.getPatientByCf(cf);
	}
	
	@GetMapping("/getByDate/{doV}")
	public List<Patient> getTodayList(@PathVariable String doV) {
		return patientService.getPatientByDate(doV);
	}
	
	@DeleteMapping("/delete/{cf}")
	public void deletePatientByCf(@PathVariable String cf) {
		patientService.deletePatientByCf(cf);
	}
	
	@PutMapping("/update")
	public void updatePatientByCf(@RequestBody Patient patient) {
		patientService.updatePatientByCf(patient);
	}
	
}
