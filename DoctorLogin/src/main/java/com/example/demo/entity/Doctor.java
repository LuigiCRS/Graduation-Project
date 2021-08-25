package com.example.demo.entity;

public class Doctor {
	
	
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
		Id = id;
		Name = name;
		Surname = surname;
		Email = email;
		Password = password;
		DoB = doB;
	}
	
	
	public Doctor(Doctor doctor) {
		Id = doctor.getId();
		Name = doctor.getName();
		Surname = doctor.getSurname();
		Email = doctor.getEmail();
		Password = doctor.getPassword();
		DoB = doctor.getDoB();
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return Surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		Surname = surname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * @return the doB
	 */
	public String getDoB() {
		return DoB;
	}
	/**
	 * @param doB the doB to set
	 */
	public void setDoB(String doB) {
		DoB = doB;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DoB == null) ? 0 : DoB.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (DoB == null) {
			if (other.DoB != null)
				return false;
		} else if (!DoB.equals(other.DoB))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Doctor [Id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", Email=" + Email + ", Password="
				+ Password + ", DoB=" + DoB + "]";
	}



	private Integer Id;
	private String Name;
	private String Surname;
	private String Email;
	private String Password;
	private String DoB; //Date of Birth
}
