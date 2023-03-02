package com.example.finalexam.controller;

import com.example.finalexam.dto.PictureDTO;
import com.example.finalexam.model.Category;
import com.example.finalexam.model.Picture;
import com.example.finalexam.service.category.ICategoryService;
import com.example.finalexam.service.picture.IPictureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private String findAllPicture(Model model, @PageableDefault(size = 5, page = 0) Pageable pageable,
                                  @RequestParam(defaultValue = "", required = false) String nameSearch,
                                  @RequestParam(defaultValue = "0", required = false) Long idSearch) {
        Category category = this.categoryService.findById(idSearch).orElse(null);
        Page<Picture> pictures;
        if (category != null) {
            pictures = this.pictureService.findAllByNameAndCategoryId(nameSearch, idSearch, pageable);
        } else {
            pictures = this.pictureService.findAllByName(nameSearch, pageable);
        }
        model.addAttribute("pictures", pictures);
        model.addAttribute("categories", this.categoryService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("idSearch", idSearch);
        model.addAttribute("pictureDTO", new PictureDTO());
        return "/list";
    }

    @PostMapping("/create")
    private String save(@Validated @ModelAttribute PictureDTO pictureDTO, BindingResult bindingResult,
                        Model model, @PageableDefault(size = 5, page = 0) Pageable pageable,
                        @RequestParam(defaultValue = "", required = false) String nameSearch,
                        @RequestParam(defaultValue = "0", required = false) Long idSearch,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Category category = this.categoryService.findById(idSearch).orElse(null);
            Page<Picture> pictures;
            if (category != null) {
                pictures = this.pictureService.findAllByNameAndCategoryId(nameSearch, idSearch, pageable);
            } else {
                pictures = this.pictureService.findAllByName(nameSearch, pageable);
            }
            model.addAttribute("pictures", pictures);
            model.addAttribute("categories", this.categoryService.findAll());
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("idSearch", idSearch);
            model.addAttribute("pictureDTO", pictureDTO);
            model.addAttribute("hasErrors", "true");
            return "/list";
        }
        Picture picture = new Picture();
        BeanUtils.copyProperties(pictureDTO, picture);
        if (this.pictureService.save(picture)) {
            redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Thêm mới thất bại");
        }
        return "redirect:/picture";
    }

    @PostMapping("/delete")
    private String deleteById(@RequestParam Long idDelete, RedirectAttributes redirectAttributes) {
        if (this.pictureService.removeById(idDelete)) {
            redirectAttributes.addFlashAttribute("mess", "Xóa tác phẩm thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess",
                    "Tác phẩm không tồn tại, xóa tác phẩm thất bại");
        }
        return "redirect:/picture";
    }
}
