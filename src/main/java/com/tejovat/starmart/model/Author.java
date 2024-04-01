package com.tejovat.starmart.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
	private List<Books> books;

	public Author() {
		super();
	}

	public Author(Long id, String authorName, String typeOfAuthor, Boolean isLive, List<Books> books) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.typeOfAuthor = typeOfAuthor;
		this.isLive = isLive;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTypeOfAuthor() {
		return typeOfAuthor;
	}

	public void setTypeOfAuthor(String typeOfAuthor) {
		this.typeOfAuthor = typeOfAuthor;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}
}
