package com.example.formvalidate.controller;

import com.example.formvalidate.dto.UserDTO;
import com.example.formvalidate.model.User;
import com.example.formvalidate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public String getFormPage(@Validated @ModelAttribute UserDTO userDTO, BindingResult bindingResult,
                              Model model) {
        new UserDTO().validate(userDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "/form";
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.saveUser(user);
        model.addAttribute("mess", "Đăng kí thành công rồi nha!");
        return "/result";
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/form";
    }
}
