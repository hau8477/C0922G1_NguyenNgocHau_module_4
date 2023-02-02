package com.example.springusermodel.repository.impl;

import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;
import com.example.springusermodel.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("john", "123456", "John", "john@codegym.vn", 20));
        users.add(new User("bill", "121212", "Bill", "bill@codegym.vn", 21));
        users.add(new User("mike", "232323", "Mike", "mike@codegym.vn", 22));
        users.add(new User("hold", "454545", "Hold", "hold@codegym.vn", 19));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
