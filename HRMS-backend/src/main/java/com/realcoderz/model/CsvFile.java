package com.realcoderz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CsvFile {
	
	@Id
	private long id;
	private String name;
	private String college;
	private String city;
	
	public CsvFile(long id, String name, String college, String city) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CsvFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
