package com.example.demo.entity;

public class Patient {
	
	/**
	 * 
	 */
	public Patient() {
		super();
	}
	/**
	 * @param name
	 * @param surname
	 * @param cf
	 * @param doB
	 * @param doV
	 * @param hour
	 */
	public Patient(String name, String surname, String cf, String doB, String doV, String hour, String phone) {
		this.name = name;
		this.surname = surname;
		this.cf = cf;
		this.doB = doB;
		this.doV = doV;
		this.hour = hour;
		this.phoneNumber = phone;
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
	 * @return the cf
	 */
	public String getCf() {
		return cf;
	}
	/**
	 * @param cf the cf to set
	 */
	public void setCf(String cf) {
		this.cf = cf;
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
	/**
	 * @return the doV
	 */
	public String getDoV() {
		return doV;
	}
	/**
	 * @param doV the doV to set
	 */
	public void setDoV(String doV) {
		this.doV = doV;
	}
	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	
	
	


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}






	@Override
	public String toString() {
		return "Name: " + name + "\nSurname: " + surname + "\nCF: " + cf + "\ndoB: " + doB + "\ndoV: " + doV
				+ "\nhour: " + hour + "\nphoneNumber: " + phoneNumber + "\n";
	}







	private String name;
	private String surname;
	private String cf;
	private String doB; //Date of birth
	private String doV; //Date of vaccination
	private String hour;
	private String phoneNumber;
}
