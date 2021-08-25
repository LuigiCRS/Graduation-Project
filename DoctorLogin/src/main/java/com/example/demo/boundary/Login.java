package com.example.demo.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.demo.control.LoginRequest;
import com.example.demo.control.RegistrationStore;
import com.example.demo.entity.Doctor;


public class Login {
	
	
	private final RegistrationStore registrationStore = new RegistrationStore();
	private final LoginRequest loginRequest = new LoginRequest();
	
	
	public void runApplication() throws IOException {
		System.out.println("*** GESTORE DEL CENTRO VACCINALE ***");
		System.out.println("1. Login");
		System.out.println("2. Registration");
		System.out.print(": ");
		int reply = 0;
		reply = Integer.parseInt(in.readLine());
		switch (reply) {
		case 1:
			this.loginAttempt = 3;
			loginPanel();
			break;
			
		case 2:
			this.registrationAttempt = 3;
			registrationForm();
			break;
		default:
			System.out.println("Number not valid.\n\n");
			runApplication();
			break;
		}
		in.close();
			
	}
	
	
	
	private void registrationForm() throws IOException {
		Doctor doctor = new Doctor();
		System.out.println("\n\n*** REGISTRATION FORM ***\n");
		System.out.print("Name: ");
		doctor.setName(in.readLine());
		System.out.print("Surname: ");
		doctor.setSurname(in.readLine());
		System.out.print("Email: ");
		doctor.setEmail(in.readLine());
		System.out.print("Password: ");
		doctor.setPassword(in.readLine());
		System.out.print("Date of Birth (dd/mm/yyyy): ");
		doctor.setDoB(in.readLine());
		if(registrationStore.dataValidation(doctor.getEmail())) {
			registrationStore.putRequest(doctor);
			System.out.println("Registration success.");
		} else if(!(registrationAttempt == 0)){
			this.registrationAttempt--;
			System.out.println("Email not valid! Retry!\nLast " + registrationAttempt + " attempt.\n");
			registrationForm();
		}
		runApplication();
	}
	
	private void loginPanel() throws IOException {
		System.out.println("\n\n*** LOGIN ***\n");
		System.out.print("Email: ");
		String email = in.readLine();
		System.out.print("Password: ");
		String password = in.readLine();
		if(loginRequest.dataValidation(email, password)) {
			System.out.println("Authentication success. Redirection.");
			loginRequest.authentication();
		} else if(!(this.loginAttempt == 0)){
			this.loginAttempt--;
			System.out.println("Email or password not correct. Last " + loginAttempt + " attempt.");
			loginPanel();
		}
		if (this.loginAttempt == 0) {
			runApplication();
		}
	};
	
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private int registrationAttempt;
	private int loginAttempt;
}
