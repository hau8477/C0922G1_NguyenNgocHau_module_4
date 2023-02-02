package com.example.springusermodel.service;

import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
