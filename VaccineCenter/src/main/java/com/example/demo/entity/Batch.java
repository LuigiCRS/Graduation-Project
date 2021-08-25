package com.example.demo.entity;

public class Batch {

	
	
	
	/**
	 * 
	 */
	public Batch() {
		super();
	}
	/**
	 * @param id
	 * @param pharmaceuticalCompany
	 * @param numberOfDoses
	 * @param doU
	 */
	public Batch(Integer id, String pharmaceuticalCompany, Integer numberOfDoses, String doU) {
		this.id = id;
		this.pharmaceuticalCompany = pharmaceuticalCompany;
		this.numberOfDoses = numberOfDoses;
		this.doU = doU;
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
	 * @return the pharmaceuticalCompany
	 */
	public String getPharmaceuticalCompany() {
		return pharmaceuticalCompany;
	}
	/**
	 * @param pharmaceuticalCompay the pharmaceuticalCompay to set
	 */
	public void setPharmaceuticalCompany(String pharmaceuticalCompany) {
		this.pharmaceuticalCompany = pharmaceuticalCompany;
	}
	/**
	 * @return the numberOfDoses
	 */
	public Integer getNumberOfDoses() {
		return numberOfDoses;
	}
	/**
	 * @param numberOfDoses the numberOfDoses to set
	 */
	public void setNumberOfDoses(Integer numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}
	/**
	 * @return the doU
	 */
	public String getDoU() {
		return doU;
	}
	/**
	 * @param doU the doU to set
	 */
	public void setDoU(String doU) {
		this.doU = doU;
	}
	
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", pharmaceuticalCompany=" + pharmaceuticalCompany + ", numberOfDoses=" + numberOfDoses
				+ ", doU=" + doU + "]";
	}



	private Integer id;
	private String pharmaceuticalCompany;
	private Integer numberOfDoses;
	private String doU; //Date of Use
}
