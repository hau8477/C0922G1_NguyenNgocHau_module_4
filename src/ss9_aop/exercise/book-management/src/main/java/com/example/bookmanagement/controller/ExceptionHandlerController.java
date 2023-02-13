package com.example.bookmanagement.controller;

import com.example.bookmanagement.common.InvalidCodeException;
import com.example.bookmanagement.common.OutOfBookException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerController {
    @org.springframework.web.bind.annotation.ExceptionHandler(OutOfBookException.class)
    public String getPageErrorOutOfBook(Model model){
        model.addAttribute("mess",new OutOfBookException("Số lượng sách đã hết").getMessage());
        return "/error/out-of-book";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidCodeException.class)
    public String getPageErrorInvalidCode(Model model){
        model.addAttribute("mess",new InvalidCodeException("Mã mượn sách không hợp lệ").getMessage());
        return "/error/invalid-code";
    }
}
