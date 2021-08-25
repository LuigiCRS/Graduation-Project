package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
	
	
	private final PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	
	public Patient getPatientByCf(String cf) {
		return patientRepository.findByCf(cf);
	}
	
	public void deletePatientByCf(String cf) {
		patientRepository.deleteById(cf);
	}
	
	public List<Patient> getPatientByDate(String date) {
		return patientRepository.findByDoV(date, Sort.by("hour"));
	}


	public void updatePatientByCf(Patient patient) {
		patientRepository.updatePatient(patient.getName(), patient.getSurname(), patient.getDoB(), patient.getPhoneNumber(), patient.getCf());
	}
}
