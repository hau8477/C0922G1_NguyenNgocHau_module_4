package com.example.finalexam.service.category;

import com.example.finalexam.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findById(Long id);
    List<Category> findAll();
}
