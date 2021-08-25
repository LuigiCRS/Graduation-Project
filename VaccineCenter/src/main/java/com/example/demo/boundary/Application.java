package com.example.demo.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.example.demo.entity.User;

public class Application extends Thread{
	
	
	public Application(User user) {
		setUser(user);
	}
	
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.println("Error sleep.");;
		}
		System.out.println("Name: " + this.user.getName());
		System.out.println("Surname: " + this.user.getSurname());
		System.out.println("\n*** Vaccine Center Manager ***");
		System.out.println("1. Patient Managment.");
		System.out.println("2. Batch Managment.");
		System.out.println("3. Log out.");
		System.out.print(": ");
		try {
			int reply = Integer.parseInt(in.readLine());
			switch (reply) {
			case 1:
				patientPanel.patientBoundary(user);
				run();
				break;
				
			case 2:
				batchPanel.batchBoundary(user);
				run();
				break;
			
			case 3:
				System.out.println("Log out done.");
				break;
				
			default:
				System.out.println("Number not valid.\n \n");
				run();
				break;
			}
		} catch (NumberFormatException | IOException e) {
			System.err.println("Application reading error.");
		}
	}
	
	
	public void setUser(User user) {
		this.user.setName(user.getName());
		this.user.setSurmame(user.getSurname());
	}
	
	protected User user = new User();
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	private PatientBoundary patientPanel = new PatientBoundary();
	private BatchBoundary batchPanel = new BatchBoundary();
}
