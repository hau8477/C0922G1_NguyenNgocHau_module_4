package com.example.bookmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Long quantity;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Borrower> borrower;

    public Book() {
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Set<Borrower> getBorrower() {
        return borrower;
    }

    public void setBorrower(Set<Borrower> borrower) {
        this.borrower = borrower;
    }
}
