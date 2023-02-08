package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.blog.IBlogService;
import com.codegym.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getPageHome(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                              @PageableDefault(sort = "localDate", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findAll(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        return "/blog/index";
    }

    @GetMapping("/list-blog")
    public String findAllBlog(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                              @PageableDefault(size = 5, page = 0, sort = "localDate", direction = Sort.Direction.ASC)
                              Pageable pageable) {
        Page<Blog> blog1 = blogService.findAll(nameSearch.trim(), pageable);
        model.addAttribute("blogs", blog1);
        model.addAttribute("blog", new Blog());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "/blog/list";
    }

    @GetMapping("/list-blog-by-category")
    public String findByCategoryBlog(Model model, @RequestParam(required = false, defaultValue = "0") Long nameSearch,
                                     @PageableDefault(size = 5, page = 0, sort = "localDate", direction = Sort.Direction.ASC)
                                     Pageable pageable) {
        model.addAttribute("blogs", blogService.findByCategory(nameSearch, pageable));
        model.addAttribute("blog", new Blog());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "/blog/list";
    }

    @GetMapping("/edit-blog/{id}")
    public String editBlog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAllCategory());
        return "/blog/edit";
    }

    @GetMapping("/view-blog/{id}")
    public String getViewPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAllCategory());
        return "/blog/view";
    }

    @PostMapping("/update-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Update successful!");
        return "/blog/edit";
    }

    @GetMapping("/delete-blog")
    public String deleteBlog(@RequestParam("idDelete") Long id, RedirectAttributes redirectAttributes) {
        blogService.removeById(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/list-blog";
    }

    @PostMapping("/create-blog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/list-blog";
    }
}
