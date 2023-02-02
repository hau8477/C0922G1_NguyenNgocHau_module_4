package com.example.email.service;

import com.example.email.model.Email;

import java.util.List;
import java.util.Map;

public interface IEmailService {
    List<Email> findAllEmail();

    void updateEmail(int id, Email email);

    Email findById(int id);

}
