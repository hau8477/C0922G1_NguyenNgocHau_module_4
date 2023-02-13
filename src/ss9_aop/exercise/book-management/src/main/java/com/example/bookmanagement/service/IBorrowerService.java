package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<Borrower> findAllBorrower();

    String setCodeBorrower();
}
