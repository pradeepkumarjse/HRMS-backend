package com.realcoderz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long e_id;
	
	@Column(name="name")
	private String e_name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date e_date;
	
	@Column(name="email")
	private String e_email;
	
	@Column(name="mobile")
	private String e_mobile;
	
	@Column(name="gender")
	private String e_gender;
	
	@Column(name="userid")
	private String e_userid;
	
	@Column(name="password")
	private String e_password;
	
	
	@Column(name="city")
	private String e_city;
	
	


	public Long getE_id() {
		return e_id;
	}

	public void setE_id(Long e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public String getE_mobile() {
		return e_mobile;
	}

	public void setE_mobile(String e_mobile) {
		this.e_mobile = e_mobile;
	}

	public String getE_gender() {
		return e_gender;
	}

	public void setE_gender(String e_gender) {
		this.e_gender = e_gender;
	}

	public String getE_userid() {
		return e_userid;
	}

	public void setE_userid(String e_userid) {
		this.e_userid = e_userid;
	}

	public String getE_password() {
		return e_password;
	}

	public void setE_password(String e_password) {
		this.e_password = e_password;
	}


	public String getE_city() {
		return e_city;
	}

	public void setE_city(String e_city) {
		this.e_city = e_city;
	}

	
	


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long e_id, String e_name, Date e_date, String e_email, String e_mobile, String e_gender,
			String e_userid, String e_password, String e_city) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_date = e_date;
		this.e_email = e_email;
		this.e_mobile = e_mobile;
		this.e_gender = e_gender;
		this.e_userid = e_userid;
		this.e_password = e_password;
		this.e_city = e_city;
	
		
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_date=" + e_date + ", e_email=" + e_email
				+ ", e_mobile=" + e_mobile + ", e_gender=" + e_gender + ", e_userid=" + e_userid + ", e_password="
				+ e_password + ", e_city=" + e_city + "]";
	}


}