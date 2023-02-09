package com.example.songmanagement.controller;

import com.example.songmanagement.dto.SongDTO;
import com.example.songmanagement.model.Song;
import com.example.songmanagement.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    private String getPageHome(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        model.addAttribute("songs", songService.findAll(pageable));
        model.addAttribute("songDTO", new SongDTO());
        return "/home";
    }

    @PostMapping("/create")
    private String saveSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model,
                            @PageableDefault(page = 0, size = 10) Pageable pageable) {
        new SongDTO().validate(songDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("songs", songService.findAll(pageable));
            model.addAttribute("songDTO", songDTO);
            model.addAttribute("hasError", "true");
            return "/home";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm bài hát mới thành công");
        return "redirect:/";
    }

    @PostMapping("/edit")
    private String editSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model,
                            @PageableDefault(page = 0, size = 10) Pageable pageable) {
        new SongDTO().validate(songDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("songs", songService.findAll(pageable));
            model.addAttribute("songDTO", songDTO);
            model.addAttribute("hasError", "true");
            return "/home";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa bài hát mới thành công");
        return "redirect:/";
    }
}
