package com.example.bookmanagement.controller;

import com.example.bookmanagement.common.InvalidCodeException;
import com.example.bookmanagement.common.OutOfBookException;
import com.example.bookmanagement.model.Borrower;
import com.example.bookmanagement.service.IBookService;
import com.example.bookmanagement.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowerService borrowerService;

    @GetMapping("")
    public String findAllBook(Model model) {
        model.addAttribute("books", bookService.findAllBook());
        model.addAttribute("borrower", new Borrower());
        return "/list-book";
    }

    @PostMapping("/borrow-book")
    public String borrowBook(@ModelAttribute("borrower") Borrower borrower, Model model) throws OutOfBookException {
        String code = borrowerService.setCodeBorrower();
        borrower.setCode(code);
        if (bookService.borrowerBook(borrower)) {
            model.addAttribute("mess", "Mượn sách thành công, " + "mã mượn sách là: " + code);
            model.addAttribute("books", bookService.findAllBook());
        } else {
            model.addAttribute("books", bookService.findAllBook());
            model.addAttribute("mess", "Mượn sách thất bại");
        }
        return "/list-book";
    }

    @GetMapping("/return-book")
    public String returnBook(RedirectAttributes redirectAttributes, @RequestParam("code") String code) throws InvalidCodeException {
        if (bookService.returnBook(code)) {
            redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
        } else {
            redirectAttributes.addFlashAttribute("mess", "Trả sách không thành công");
            redirectAttributes.addFlashAttribute("books", bookService.findAllBook());
        }
        return "redirect:/";
    }
}
