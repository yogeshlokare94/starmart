package com.tejovat.starmart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Table
@Entity(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstname")
	@NotEmpty(message="First Name can't be empty")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@NotEmpty(message="User Name can't be empty")
	private String username;
	
	@JsonIgnore
	private String password;
	
	@Column(name="active")
	private Boolean isActive;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="employee_role_mapping", joinColumns = {
			@JoinColumn(name="employee_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
	}, inverseJoinColumns = {
			@JoinColumn(name="role_id", referencedColumnName = "id",nullable = false, insertable=false, updatable=false)
	})
	private List<Roles> roles;

	public Employee() {
		super();
	}

	public Employee(Long id, @NotEmpty(message = "First Name can't be empty") String firstName, String lastName,
			@NotEmpty(message = "User Name can't be empty") String username, String password, Boolean isActive,
			List<Roles> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
