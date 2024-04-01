package com.tejovat.starmart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table
@Entity(name="role")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	@NotNull(message="Role Name Can't be Null")
	private String roleName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private List<Employee> employees;

	public Roles() {
		super();
	}

	public Roles(Long id, @NotNull(message = "Role Name Can't be Null") String roleName, List<Employee> employees) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
