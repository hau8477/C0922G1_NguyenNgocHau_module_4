package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "number1", required = false, defaultValue = "0") double number1,
                             @RequestParam(value = "number2", required = false, defaultValue = "0") double number2,
                             @RequestParam String action, Model model) {
        double result = 0;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "multiplication":
                result = number1 * number2;
                break;
            case "division":
                if (number2 == 0) {
                    model.addAttribute("result", "Infinity");
                }
                result = number1 / number2;
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("action", action);
        model.addAttribute("result", result);
        return "index";
    }
}
