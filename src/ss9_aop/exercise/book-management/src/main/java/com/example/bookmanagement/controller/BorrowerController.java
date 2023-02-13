package com.example.bookmanagement.controller;

import com.example.bookmanagement.service.IBookService;
import com.example.bookmanagement.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorrowerController {
    @Autowired
    private IBorrowerService borrowerService;

    @GetMapping("/list-borrower-book")
    public String findAllBorrower(Model model) {
        model.addAttribute("listBorrower", borrowerService.findAllBorrower());
        return "/list-borrower";
    }
}
