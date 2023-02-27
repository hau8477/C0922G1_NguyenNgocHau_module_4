package com.example.controller.home;

import com.example.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "/login";
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String getPageHome() {
        return "/home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutSuccessfulPage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Đăng xuất thành công!");
        return "/login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền truy cập trang này!";
            model.addAttribute("message", message);

        }

        return "/403Page";
    }

}