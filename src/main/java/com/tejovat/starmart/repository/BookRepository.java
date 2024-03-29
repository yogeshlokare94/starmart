package com.tejovat.starmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.starmart.model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

}
