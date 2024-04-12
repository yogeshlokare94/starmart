package com.tejovat.starmart.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity(name="customer")
public class Customer extends AuditorEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotNull(message="FirstName can't be null")
	@Size(min=3, message="Name at least 3 characters")
	@Column(name="firstname")
	private String firstName; //getFirstName() setFirstName(String firstName)
	
	@NotNull(message="LastName can't be null")
	@Column(name="lastname")
	private String lastName;
	
	@NotBlank(message = "Email can't be empty")
	@Email(message="Please enter Email correctly")
	private String email;
	
	@Size(min=10, max= 12, message = "Please enter contact no. more than 10 digit & less than 12 digit")
	@Column(name="contactno")
	private String contactNo;
	
	@AssertTrue
	private Boolean active;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
}
