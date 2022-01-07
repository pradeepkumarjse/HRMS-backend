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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee_table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long e_id;
	
	
	@Size(min=2,message="employee name should have at lest 2 character")
	@Column(name="name")
	private String e_name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date e_date;
	
	
//	@Email
//	@Pattern(regexp="^(.+)@(.+)$")
	@Column(name="email")
	private String e_email;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@Size(min=10,max=10,message="phone number should have at least 10 character")
	@Column(name="mobile")
	private String e_mobile;
	
	
	@Column(name="gender")
	private String e_gender;
	
	@Size(min=5,message="userid should have at least 5 character")
	@Column(name="userid")
	private String e_userid;
	
	@Size(min=5,message="password should have at lest 5 character")
	@Column(name="password")
	private String e_password;
	
	@Column(name="street")
	private String e_street;
	
	@Column(name="city")
	private String e_city;
	
	@Column(name="address")
	private String address;
	 
	@Lob
	private byte[] image;
	
	@Lob
	private byte[] adharimage;
	
	@Lob
	private byte[] panimage;

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

	public String getE_street() {
		return e_street;
	}

	public void setE_street(String e_street) {
		this.e_street = e_street;
	}

	public String getE_city() {
		return e_city;
	}

	public void setE_city(String e_city) {
		this.e_city = e_city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getAdharimage() {
		return adharimage;
	}

	public void setAdharimage(byte[] adharimage) {
		this.adharimage = adharimage;
	}

	public byte[] getPanimage() {
		return panimage;
	}

	public void setPanimage(byte[] panimage) {
		this.panimage = panimage;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long e_id, String e_name, Date e_date, String e_email, String e_mobile, String e_gender,
			String e_userid, String e_password, String e_street, String e_city, String address, byte[] image,
			byte[] adharimage, byte[] panimage) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_date = e_date;
		this.e_email = e_email;
		this.e_mobile = e_mobile;
		this.e_gender = e_gender;
		this.e_userid = e_userid;
		this.e_password = e_password;
		this.e_street = e_street;
		this.e_city = e_city;
		this.address = address;
		this.image = image;
		this.adharimage = adharimage;
		this.panimage = panimage;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_date=" + e_date + ", e_email=" + e_email
				+ ", e_mobile=" + e_mobile + ", e_gender=" + e_gender + ", e_userid=" + e_userid + ", e_password="
				+ e_password + ", e_street=" + e_street + ", e_city=" + e_city + ", address=" + address + ", image="
				+ Arrays.toString(image) + ", adharimage=" + Arrays.toString(adharimage) + ", panimage="
				+ Arrays.toString(panimage) + "]";
	}

	


}
