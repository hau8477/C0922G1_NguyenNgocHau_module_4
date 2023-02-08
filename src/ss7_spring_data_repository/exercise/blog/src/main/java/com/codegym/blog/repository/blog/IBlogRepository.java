package com.codegym.blog.repository.blog;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitleContaining(String nameSearch, Pageable pageable);
}
