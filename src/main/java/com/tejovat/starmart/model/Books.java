package com.tejovat.starmart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Table
@Entity(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="book_name")
	@NotEmpty(message="book name should not be empty")
	private String bookName;
	
	@Column(name="published_year")
	private Integer publishedYear;
	
	@Column(name="publication_name")
	private String publicationName;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	@JsonIgnore
	private Author author;

	public Books() {
		super();
	}

	public Books(Long id, @NotEmpty(message = "book name should not be empty") String bookName, Integer publishedYear,
			String publicationName, Author author) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.publishedYear = publishedYear;
		this.publicationName = publicationName;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
