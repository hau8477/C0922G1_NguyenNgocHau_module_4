package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog, Long> {

}
