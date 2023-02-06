package com.example.productmanagementthymeleaf.controller;

import com.example.productmanagementthymeleaf.model.SmartPhone;
import com.example.productmanagementthymeleaf.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("")
    public String getHomePage(Model model) {
        model.addAttribute("smartphones", smartphoneService.findAll());
        model.addAttribute("smartphone", new SmartPhone());
        return "/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("smartphone") SmartPhone smartPhone,RedirectAttributes attributes) {
        if(smartphoneService.save(smartPhone)){
            attributes.addFlashAttribute("mess","Add new Successful!");
        } else {
            attributes.addFlashAttribute("mess","Add new fail!");
        }
        return "redirect:/smartphone";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("smartphone", smartphoneService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("smartphone") SmartPhone smartPhone) {
        smartphoneService.update(smartPhone);
        model.addAttribute("mess", "Update successful!");
        return "/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") int id, RedirectAttributes attributes) {
        smartphoneService.remove(id);
        attributes.addFlashAttribute("mess", "Delete successful!");
        return "redirect:/smartphone";
    }

    @GetMapping("/view/{id}")
    public String getViewPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("smartphone", smartphoneService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String name, Model model) {
        model.addAttribute("smartphones", smartphoneService.search(name));
        return "/index";
    }
}
