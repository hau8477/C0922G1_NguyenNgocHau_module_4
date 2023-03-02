package com.example.finalexam.repository;

import com.example.finalexam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
