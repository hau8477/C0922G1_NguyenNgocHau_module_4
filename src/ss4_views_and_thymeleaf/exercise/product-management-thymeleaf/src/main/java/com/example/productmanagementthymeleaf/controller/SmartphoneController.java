package com.example.productmanagementthymeleaf.controller;

import com.example.productmanagementthymeleaf.model.SmartPhone;
import com.example.productmanagementthymeleaf.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("smartphones",smartphoneService.findAll());
        return "/index";
    }

    @GetMapping("")
    public String layout(Model model){
        model.addAttribute("smartphone", new SmartPhone());
        return "/layout";
    }
}
