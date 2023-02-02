package com.example.springusermodel.repository;

import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
