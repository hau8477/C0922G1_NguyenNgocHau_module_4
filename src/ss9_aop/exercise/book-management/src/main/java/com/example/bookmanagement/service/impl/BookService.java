package com.example.bookmanagement.service.impl;

import com.example.bookmanagement.common.InvalidCodeException;
import com.example.bookmanagement.common.OutOfBookException;
import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Borrower;
import com.example.bookmanagement.repository.IBookRepository;
import com.example.bookmanagement.repository.IBorrowerRepository;
import com.example.bookmanagement.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBorrowerRepository borrowerRepository;

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public boolean borrowerBook(Borrower borrower) throws OutOfBookException {
        Book book = bookRepository.findById(borrower.getBook().getId()).orElse(null);
        if (book == null) {
            return false;
        }
        if(book.getQuantity() <= 0){
            throw new OutOfBookException("Số lượng sách đã hết");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        borrowerRepository.save(borrower);
        return true;
    }

    @Override
    public boolean returnBook(String code) throws InvalidCodeException {
        Borrower borrower = borrowerRepository.findByCode(code);
        if (borrower == null) {
            throw new InvalidCodeException("Mã mượn sách không hợp lệ");
        }

        Book book = bookRepository.findById(borrower.getBook().getId()).orElse(null);
        if (book == null) {
            return false;
        }

        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowerRepository.deleteById(borrower.getId());
        return true;
    }
}
