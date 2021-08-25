package com.example.demo.entity;

public class User {

	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param surname
	 */
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
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
	 * @param surmame the surname to set
	 */
	public void setSurmame(String surmame) {
		this.surname = surmame;
	}
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + "]";
	}



	private String name;
	private String surname;
}
