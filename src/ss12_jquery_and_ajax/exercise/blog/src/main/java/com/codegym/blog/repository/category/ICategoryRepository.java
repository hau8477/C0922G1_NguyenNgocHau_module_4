package com.codegym.blog.repository.category;

import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findByNameContaining(String nameSearch, Pageable pageable);
}
