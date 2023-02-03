package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import com.example.email.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private final IEmailService emailService = new EmailService();

    @GetMapping("/email")
    public String listEmail(Model model) {
        model.addAttribute("emails", emailService.findAllEmail());
        return "home";
    }

    @GetMapping("/edit-email")
    public String editEmail(@RequestParam("id") int id, Model model) {
        model.addAttribute("newEmail", emailService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute("newEmail") Email email) {
        emailService.updateEmail(email.getId(), email);
        return "redirect: /email";
    }
}
