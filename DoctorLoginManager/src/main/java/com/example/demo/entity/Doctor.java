package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class Doctor {
	
	
	public Doctor(Doctor doctor) {
		id = doctor.getId();
		name = doctor.getName();
		surname = doctor.getSurname();
		email = doctor.getEmail();
		password = doctor.getPassword();
		doB = doctor.getDoB();
	}
	
	
	
	


	/**
	 * 
	 */
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}






	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 * @param doB
	 */
	public Doctor(Integer id, String name, String surname, String email, String password, String doB) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.doB = doB;
	}


	



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}






	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}






	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}






	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}






	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}






	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}






	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}






	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}






	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}






	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}






	/**
	 * @return the doB
	 */
	public String getDoB() {
		return doB;
	}






	/**
	 * @param doB the doB to set
	 */
	public void setDoB(String doB) {
		this.doB = doB;
	}






	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", doB=" + doB + "]";
	}






	private @Id @GeneratedValue Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String doB; //Date of Birth
}
