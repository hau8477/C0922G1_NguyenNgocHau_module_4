package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String getPageHome(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "/index";
    }

    @GetMapping("/list-blog")
    public String findAllBlog(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("blog", new Blog());
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @GetMapping("/view/{id}")
    public String getViewPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Update successful!");
        return "/edit";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam("idDelete") Long id, RedirectAttributes redirectAttributes) {
        blogService.removeById(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/list-blog";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/list-blog";
    }
}
