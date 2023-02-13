package com.example.bookmanagement.service;

import com.example.bookmanagement.common.InvalidCodeException;
import com.example.bookmanagement.common.OutOfBookException;
import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Borrower;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    boolean borrowerBook(Borrower borrower) throws OutOfBookException;

    boolean returnBook(String code) throws InvalidCodeException;
}
