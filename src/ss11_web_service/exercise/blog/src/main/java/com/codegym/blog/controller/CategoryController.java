package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list-category")
    public String findAllCategory(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                                  @PageableDefault(page = 0, size = 5) Pageable pageable) {
        model.addAttribute("categories", categoryService.findAll(nameSearch.trim(), pageable));
        model.addAttribute("category", new Category());
        model.addAttribute("nameSearch", nameSearch);
        return "/category/list";
    }

    @PostMapping("/create-category")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/list-category";
    }

    @GetMapping("/edit-category/{id}")
    public String editCategory(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update-category")
    public String updateCategory(Model model, @ModelAttribute Category category){
        categoryService.update(category);
        model.addAttribute("mess","Update successful!");
        return "/category/edit";
    }
    @GetMapping("/delete-category")
    public String deleteBlog(@RequestParam("idDelete") Long id, RedirectAttributes redirectAttributes) {
        categoryService.removeById(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/list-category";
    }
}
