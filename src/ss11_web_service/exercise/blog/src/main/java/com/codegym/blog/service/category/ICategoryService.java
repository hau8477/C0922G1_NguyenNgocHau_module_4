package com.codegym.blog.service.category;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Page<Category> findAll(String nameSearch, Pageable pageable);
    List<Category> findAllCategory();

    void save(Category category);

    void update(Category category);

    Optional<Category> findById(Long id);

    void removeById(Long id);
}
