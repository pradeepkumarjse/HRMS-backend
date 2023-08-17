package com.realcoderz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Results")
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private int id;
	
	@NotEmpty
	@Size(min=5,max=50,message="user name should have at least 5 character")
    private String username;
	
	@Column(name="total_correct")
    private int totalCorrect;
    
    public Result() {
		System.out.println("Result: 0-param constructor");
	}

	public Result(int id, String username, int totalCorrect) {
		super();
		this.id = id;
		this.username = username;
		this.totalCorrect = totalCorrect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", username=" + username + ", totalCorrect=" + totalCorrect + "]";
	}
    
}
