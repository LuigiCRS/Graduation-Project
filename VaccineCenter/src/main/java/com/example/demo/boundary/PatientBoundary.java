package com.example.demo.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.demo.entity.Patient;
import com.example.demo.entity.User;
import com.example.demo.control.PatientControl;

public class PatientBoundary {
	
	
	protected void patientBoundary(User user) throws NumberFormatException, IOException {
		System.out.println("*** Patient Manger ***");
		System.out.println("1. Today Patient List Request.");
		System.out.println("2. Confirm vaccination.");
		System.out.println("3. Search Paitent.");
		System.out.println("4. Modify Patient.");
		System.out.println("5. Delete Patient.");
		System.out.println("6. Show patient list by date.");
		System.out.print(": ");
		int reply = Integer.parseInt(in.readLine());
		switch (reply) {
		case 1:
			todayList();
			break;
			
		case 2:
			confirmVaccination(user);
			break;
			
		case 3:
			searchPatientByCf();
			break;
			
		case 4:
			updatePatient();
			break;
			
		case 5:
			deletePatient();
			break;
			
		case 6:
			showByDate();
			break;
			
		default:
			System.out.println("Number not valid.");
			break;
		}
	}

	
	private void confirmVaccination(User user) throws IOException {
		System.out.println("\nInsert the CF of the patient you want to confirm.\n:");
		String cf = in.readLine();
		Patient patient = patientControl.findByCf(cf);
		if(patient != null) {
			System.out.println(patient.toString());
			patientControl.confirmVaccination(cf, user);
		} else {
			System.out.println("Patient not found.");
		}
		
	}


	private void todayList() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("Patient list of " + date.format(formatter));
		List<Patient> patientList = patientControl.todayPatientList(date.format(formatter).toString());
		int i = 1;
		for(Patient p : patientList) {
			System.out.println("Number: " + i++);
			System.out.println(p.toString());
		}
	}
	
	private void showByDate() throws IOException {
		System.out.println("\nInsert the date (GG-MM-YYYY).\n: ");
		String date = in.readLine();
		System.out.println("Patient list of " + date);
		List<Patient> patientList = patientControl.todayPatientList(date);
		int i = 1;
		for(Patient p : patientList) {
			System.out.println("Number: " + i++);
			System.out.println(p.toString());
		}
	}
	
	
	private void searchPatientByCf() throws IOException {
		System.out.print("\nInsert the CF of the patient you want to found\n: ");
		String cf = in.readLine();
		System.out.println("\nPatient data below.");
		Patient patient = patientControl.findByCf(cf);
		if(patient != null) {
			System.out.println(patient.toString());
		} else {
			System.out.println("Patient not found.");
		}
	}
	
	
	private void deletePatient() throws IOException {
		System.out.print("\nInsert the CF of the patient you want to delete\n: ");
		String cf = in.readLine();
		Patient patient = patientControl.findByCf(cf);
		if(patient != null) {
			patientControl.deletePatient(cf);
		} else {
			System.out.println("Patient not found.");
		}
	}
	
	private void updatePatient() throws IOException {
		System.out.print("\nInsert the CF of the patient you want to update\n: ");
		String cf = in.readLine();
		Patient patient = patientControl.findByCf(cf);
		if(patient != null) {
			System.out.println(patient.toString());
			System.out.println("\nIf you don't want to update something press ENTER.\n");
			System.out.print("New name: ");
			String name = in.readLine();
			if(!name.equals("")) {
				patient.setName(name);
			}
			System.out.print("New surname: ");
			String surname = in.readLine();
			if(!surname.equals("")) {
				patient.setSurname(surname);
			}
			System.out.print("New date of birth (GG-MM-YYYY): ");
			String doB = in.readLine();
			if(!doB.equals("")) {
				patient.setDoB(doB);
			}
			System.out.print("New phone number: ");
			String phone = in.readLine();
			if(!phone.equals("")) {
				patient.setPhoneNumber(phone);
			}
			patientControl.updatePatient(patient);
			System.out.println("Update done.");
		} else {
			System.out.println("Patient not found.");
		}
	}
	
	
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private final PatientControl patientControl = new PatientControl();
}
