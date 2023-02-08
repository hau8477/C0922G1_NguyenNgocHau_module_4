package com.codegym.blog.service.blog;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBlogService {
    Page<Blog> findAll(String nameSearch, Pageable pageable);
    Page<Blog> findByCategory(Long id, Pageable pageable);

    void save(Blog blog);

    void update(Blog blog);

    Optional<Blog> findById(Long id);

    void removeById(Long id);
}
