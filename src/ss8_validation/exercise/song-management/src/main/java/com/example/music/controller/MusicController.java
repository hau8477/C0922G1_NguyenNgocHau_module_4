package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.model.MusicDto;
import com.example.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    IMusicService musicService;
    @RequestMapping("")
    public String showList(Model model){
        model.addAttribute("musicList",musicService.findAll());
        model.addAttribute("musicDto",new MusicDto());
        return "/home";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                       RedirectAttributes redirect,Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("musicList",musicService.findAll());
            model.addAttribute("musicDto",musicDto);
            model.addAttribute("hasError", "true");
            return "/home";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        musicService.save(music);
        redirect.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                       RedirectAttributes redirect,Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("musicList",musicService.findAll());
            model.addAttribute("musicDto",musicDto);
            model.addAttribute("hasErr", "true");
            return "/home";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        musicService.save(music);
        redirect.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/";
    }

}
