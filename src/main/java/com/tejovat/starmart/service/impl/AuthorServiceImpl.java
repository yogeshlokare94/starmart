package com.tejovat.starmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.model.Author;
import com.tejovat.starmart.repository.AuthorRepository;
import com.tejovat.starmart.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

}
