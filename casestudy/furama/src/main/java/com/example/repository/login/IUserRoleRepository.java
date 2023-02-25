package com.example.repository.login;

import com.example.model.login.AppUser;
import com.example.model.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser user);
}
