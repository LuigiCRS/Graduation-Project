package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.boundary.Login;

@SpringBootApplication
public class CenterManagmentApplication {
	
	private static Login login = new Login();

	public static void main(String[] args) {
		SpringApplication.run(CenterManagmentApplication.class, args);
		try {
			login.runApplication();
		} catch (IOException e) {
			System.err.println("Login error detected");
			System.err.println("Source: CenterManagmentApplication.java");
		}
	}

}
