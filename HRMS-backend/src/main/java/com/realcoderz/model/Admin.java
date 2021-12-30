package com.realcoderz.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long e_id;
	
	
	private String e_name;
	
	@Temporal(TemporalType.DATE)
	private Date e_date;
	
	
	private String e_email;
	
	
	private String e_mobile;
	

	private String e_gender;
	

	private String e_userid;
	
	
	private String e_password;
	

	private String e_address;
	
	@Lob
	private byte[] image;

	




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

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long e_id, String e_name, Date e_date, String e_email, String e_mobile, String e_gender,
			String e_userid, String e_password, String e_address, byte[] image) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_date = e_date;
		this.e_email = e_email;
		this.e_mobile = e_mobile;
		this.e_gender = e_gender;
		this.e_userid = e_userid;
		this.e_password = e_password;
		this.e_address = e_address;
		this.image = image;
		
	
		
	}

	@Override
	public String toString() {
		return "Admin [e_id=" + e_id + ", e_name=" + e_name + ", e_date=" + e_date + ", e_email=" + e_email
				+ ", e_mobile=" + e_mobile + ", e_gender=" + e_gender + ", e_userid=" + e_userid + ", e_password="
				+ e_password + ", e_address=" + e_address + ", image="+ Arrays.toString(image) + "]";
	}	
}


//
//{
//"e_id":3,
//"e_name":"prakash",
// "e_date":"2021-08-08",
// "e_email":"prakash@gmail.com",
// "e_mobile":"7885459568",
// "e_gender":"male",
//"e_userid":"prakash@123",
// "e_passwor":"prakash123",
// "e_address":"patna"
// }
