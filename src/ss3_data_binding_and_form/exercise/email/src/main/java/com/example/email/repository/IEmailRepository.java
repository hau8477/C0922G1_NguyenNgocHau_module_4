package com.example.email.repository;

import com.example.email.controller.EmailController;
import com.example.email.model.Email;

import java.util.List;
import java.util.Map;

public interface IEmailRepository {
    List<Email> findAllEmail();

    void updateEmail(int id, Email email);

    Email findById(int id);
}
