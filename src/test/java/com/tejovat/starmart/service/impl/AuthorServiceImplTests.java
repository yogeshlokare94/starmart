package com.tejovat.starmart.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tejovat.starmart.model.Author;
import com.tejovat.starmart.repository.AuthorRepository;

@SpringBootTest
public class AuthorServiceImplTests {
	
	@InjectMocks
	AuthorServiceImpl authorService;
	
	@Mock
	AuthorRepository authorRepository;
	
	@Test
	public void getAuthorsTest() {
		when(authorRepository.findAll()).thenReturn(null); //null
		List<Author> authorList = authorService.getAuthors();
		assertNull(authorList);
		
		when(authorRepository.findAll()).thenReturn(Collections.emptyList()); // []
		List<Author> authorList2 = authorService.getAuthors();
		assertNotNull(authorList2);
		assertEquals(0, authorList2.size());
		
		
		Author author = new Author();
		author.setId(1L);
		author.setAuthorName("Chetan bhagat");
		author.setTypeOfAuthor("Drama");
		author.setIsLive(Boolean.TRUE);
		List<Author> list = new ArrayList<>();
		list.add(author);
		when(authorRepository.findAll()).thenReturn(list);
		List<Author> authorList1 = authorService.getAuthors();
		assertNotNull(authorList1);
		assertEquals(1, authorList1.size());
		assertEquals("Chetan bhagat", authorList1.get(0).getAuthorName());
		assertTrue(authorList1.get(0).getIsLive());
	}
}
