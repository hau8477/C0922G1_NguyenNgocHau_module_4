package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list-blog")
    public ResponseEntity<Page<Blog>> findAllBlog(@RequestParam(required = false, defaultValue = "") String nameSearch,
                                                  @PageableDefault(size = 5, page = 0, sort = "localDate", direction = Sort.Direction.ASC)
                                                  Pageable pageable) {
        Page<Blog> blog = blogService.findAll(nameSearch.trim(), pageable);
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/view-blog/{id}")
    public ResponseEntity<Optional<Blog>> getViewPage(@PathVariable("id") Long id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
