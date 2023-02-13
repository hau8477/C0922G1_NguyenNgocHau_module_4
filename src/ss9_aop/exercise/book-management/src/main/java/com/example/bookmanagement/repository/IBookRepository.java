package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
