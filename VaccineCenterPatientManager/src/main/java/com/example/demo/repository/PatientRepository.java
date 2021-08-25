package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Patient;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends CrudRepository<Patient, String>{
	
	Patient findByCf(String cf);

	List<Patient> findByDoV(String date, Sort sort);
	
	@Transactional
	@Modifying
	@Query("update Patient p set p.name = ?1, p.surname = ?2, p.doB = ?3, p.phoneNumber = ?4 where p.cf = ?5")
	void updatePatient(String name, String surname, String doB, String phoneNumber, String cf);

}
