package com.example.email.repository.impl;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailRepository implements IEmailRepository {
    private static final Map<Integer, Email> emails = new HashMap<>();

    static {
        emails.put(1, new Email(1, "English", 25, false, "Thor"));
        emails.put(2, new Email(2, "Vietnamese", 100, true, "Ngoc"));
        emails.put(3, new Email(3, "Chinese", 45, false, "Hau"));
        emails.put(4, new Email(4, "Japanese", 60, false, "Nguyen"));
    }

    @Override
    public List<Email> findAllEmail() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public void updateEmail(int id, Email email) {
        emails.put(id, email);
    }

    @Override
    public Email findById(int id) {
        return emails.get(id);
    }
}
