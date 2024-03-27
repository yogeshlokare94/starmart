package com.tejovat.starmart.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="author")
public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="author_name", length = 50, nullable = false)
	private String authorName;
	
	@Column(name="type_of_author", length = 20, nullable = true)
	private String typeOfAuthor;
	
	@Column(name="live")
	private Boolean isLive;

}
