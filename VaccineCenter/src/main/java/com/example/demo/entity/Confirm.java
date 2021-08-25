package com.example.demo.entity;

public class Confirm {
	/**
	 * 
	 */
	public Confirm() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cf
	 * @param id
	 * @param date
	 * @param hour
	 * @param name
	 * @param surname
	 */
	public Confirm(String cf, Integer id, String date, String hour, String name, String surname) {
		this.cf = cf;
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.name = name;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
	private String cf;
	private Integer id;
	private String date;
	private String hour;
	private String name;
	private String surname;
}
