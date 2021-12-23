package com.realcoderz.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Table(name = "AUTH_USER_DETAILS")
@Entity
@Data
public class User implements UserDetails {
	
	
	public User() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//username should not be empty and have at lest 5 character
  
	
    @NotEmpty
    @Size(min=5,message="Username should have at least 5 character")
	@Column(name = "USER_NAME", unique = true)
	private String userName;

	//password should not be empty and have at lest 5 character

    @NotEmpty
    @Size(min=5,message="Password should have at least 5 character")
	@Column(name = "USER_KEY")
	private String password;

    @Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

	@Column(name = "UPDATED_ON")
	private Date updatedAt;

	@NotEmpty
	@Size(min=2, message="firstName should have at least 2 character")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Email
	@Pattern(regexp="^(.+)@(.+)$")
	@NotEmpty
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})")
	@Size(min=10,max=10,message="phone number should have at least 10 character")	
	@Column(name = "phone_number")
	private String phoneNumber;

	
	
	@Column(name = "enabled")
	private boolean enabled=true;
	
	
	@Column(name="profile_pic_path",length=200)		
	private String profilePicPath;

		

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "AUTH_USER_AUTHORITY", joinColumns = @JoinColumn(referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(referencedColumnName ="id"))
	
	private List<Authority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(long id, String userName, String password, Date createdAt, Date updatedAt, String firstName,
			String lastName, String email, String phoneNumber, boolean enabled, String profilePicPath,
			List<Authority> authorities) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.profilePicPath = profilePicPath;
		this.authorities = authorities;
	}

	public User(String userName, String password, Date createdAt, String firstName, String lastName, String email,
			String phoneNumber, boolean enabled, String profilePicPath, List<Authority> authorities) {
		super();
		this.userName = userName;
		this.password = password;
		this.createdAt = createdAt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.profilePicPath = profilePicPath;
		this.authorities = authorities;
	}
	
	

}