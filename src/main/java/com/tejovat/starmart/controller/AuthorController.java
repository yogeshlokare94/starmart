package com.tejovat.starmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

	@GetMapping("")
	private ResponseEntity<?> getAuthorList(){
		return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
	}
}
