package com.example.formvalidate.service.impl;

import com.example.formvalidate.model.User;
import com.example.formvalidate.repository.IUserRepository;
import com.example.formvalidate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
