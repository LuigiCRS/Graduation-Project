package com.example.demo.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.demo.control.BatchControl;
import com.example.demo.entity.Batch;
import com.example.demo.entity.User;

public class BatchBoundary {

	public void batchBoundary(User user) throws NumberFormatException, IOException {
		System.out.println("\n*** Batch Manager ***");
		System.out.println("1. Batch Registration");
		System.out.println("2. Today number of doses.");
		System.out.println("3. Today number of doses by pharmaceutical company.");
		System.out.println(": ");
		int reply = Integer.parseInt(in.readLine());
		switch (reply) {
		case 1:
			batchRegistration();
			break;
		
		case 2:
			todayNumberOfDoses();
			break;
			
		case 3:
			dosesByPharmaceuticalCompany();
			break;
		
		default:
			System.out.println("Number not valid.");
			break;
		}
	}
	
	private void dosesByPharmaceuticalCompany() throws IOException {
		System.out.println("Insert the number of the Pharmaceutical Company\n: ");
		Integer i = 0;
		for(String c : companies) {
			System.out.println( i+1 + c.toString());
			++i;
		}
		i = Integer.parseInt(in.readLine());
		String pC = companies[i-1];
		System.out.println("Today batch list of " + pC);
		
		List<Batch> batchList = batchControl.todayDosesByOharmaceuticalCompany(pC);
		int j = 1;
		for(Batch b : batchList) {
			System.out.println("Number: " + j++);
			System.out.println(b.toString());
		}
	}

	private void todayNumberOfDoses() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("Batch list of " + date.format(formatter));
		
		List<Batch> batchList = batchControl.todayDosesList(date.format(formatter).toString());
		int i = 1;
		for(Batch b : batchList) {
			System.out.println("Number: " + i++);
			System.out.println(b.toString());
		}
	}

	private void batchRegistration() throws NumberFormatException, IOException {
		
		System.out.println("Insert the number of Pharmaceutical Company.");
		Integer i = 0;
		for(String c : companies) {
			System.out.println( i+1 + c.toString());
			++i;
		}
		i = Integer.parseInt(in.readLine());
		String pC = companies[i-1];
		System.out.println("Insert the date of use (GG-MM-YYYY)\n: ");
		String doU = in.readLine();
		System.out.println("Insert the number of doses\n: ");
		Integer number = Integer.parseInt(in.readLine());
		Batch batch = new Batch(null, pC, number, doU);
		batchControl.registration(batch);
	}

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private BatchControl batchControl = new BatchControl();
	private String[] companies = {"Moderna", "BioNTech", "Johnson & Johnson"};
}
