package com.tuningboard.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5804557678966103024L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@Column
	private String firstname;	
	@Column
	private String lastname;
	@Column
	private String password;	
	@Column
	private String email;	
	 @Column
	 private int active;	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

	/*
	 * @Builder public UserInfo(long id, String firstname, String lastname, String
	 * password, String email, int active) { this.id = id; this.firstname =
	 * firstname; this.lastname = lastname; this.password = password; this.email =
	 * email; this.active = active; }
	 */
	
	public String getEmail() {
		  return email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		// TODO Auto-generated method stub
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		  return password;
	}
	 
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;		
	}
	
	public Set<Role> getRoles() {
		  return roles;
    }
	
	public void setRoles(Set<Role> roles) {
		// TODO Auto-generated method stub
		this.roles = roles;		
	}

	public int getActive() {
		  return active;
	}	

	public void setActive(int active) {
		// TODO Auto-generated method stub
		this.active = active;
	}
}
