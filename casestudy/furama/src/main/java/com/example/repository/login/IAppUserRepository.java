package com.example.repository.login;

import com.example.model.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String userName);
}
