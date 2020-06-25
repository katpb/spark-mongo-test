package com.spark.examples;

import java.io.Serializable;
import java.sql.Timestamp;

public class PersonDetails implements Serializable {
	public PersonDetails(String personJson) {
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7220528315969785781L;
	private String country;
	private String firstName;
	private String sex;
	private String year;
	private Timestamp dateOfBirth;

	public String getCountry() {
		return country;
	}

	public void setCounty(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
