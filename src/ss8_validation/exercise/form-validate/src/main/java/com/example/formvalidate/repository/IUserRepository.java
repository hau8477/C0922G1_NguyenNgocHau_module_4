package com.example.formvalidate.repository;

import com.example.formvalidate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
