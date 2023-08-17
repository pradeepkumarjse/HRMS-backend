package com.realcoderz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "ROLE_CODE")
	private String roleCode;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleCode;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRoleCode() {
		return roleCode;
	}



	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}



	public String getRoleDescription() {
		return roleDescription;
	}



	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	
	
}