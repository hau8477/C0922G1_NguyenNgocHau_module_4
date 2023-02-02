package com.example.email.service.impl;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;
import com.example.email.repository.impl.EmailRepository;
import com.example.email.service.IEmailService;

import java.util.List;
import java.util.Map;

public class EmailService implements IEmailService {
    private final IEmailRepository emailRepository = new EmailRepository();

    @Override
    public List<Email> findAllEmail() {
        return emailRepository.findAllEmail();
    }

    @Override
    public void updateEmail(int id, Email email) {
        emailRepository.updateEmail(id, email);
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }
}
