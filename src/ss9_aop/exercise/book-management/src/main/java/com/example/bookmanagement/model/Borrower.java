package com.example.bookmanagement.model;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @UniqueElements
    private String code;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrower() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
