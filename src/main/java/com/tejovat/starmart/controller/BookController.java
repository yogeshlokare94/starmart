package com.tejovat.starmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.model.Books;
import com.tejovat.starmart.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<List<Books>> getBooksList(){
		return new ResponseEntity<List<Books>>(bookService.getAllBooks(), HttpStatus.OK);
	}

}
