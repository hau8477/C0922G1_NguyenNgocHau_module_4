package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import com.example.dictionary.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    private static final IDictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/home")
    public String showFormTranslate(){
        return "dictionary";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model){
        model.addAttribute("result",dictionaryService.translate(english));
        model.addAttribute("english",english);
        return "dictionary";
    }
}
