package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    Optional<Blog> findById(Long id);

    void removeById(Long id);
}
