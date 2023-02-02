package com.example.springusermodel.service.impl;

import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;
import com.example.springusermodel.repository.IUserRepository;
import com.example.springusermodel.repository.impl.UserRepository;
import com.example.springusermodel.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository = new UserRepository();

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
