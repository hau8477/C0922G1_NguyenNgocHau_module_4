package com.example.controller.facility;

import com.example.dto.facilitydto.FacilityDTO;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String findAll(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable,
                          @RequestParam(required = false, defaultValue = "") String nameSearch,
                          @RequestParam(required = false, defaultValue = "0") Long facilityTypeId) {
        Optional<FacilityType> facility = this.facilityTypeService.findById(facilityTypeId);
        Page<Facility> facilities;
        if (facility.isPresent()) {
            facilities = this.facilityService.findAllByNameContainingAndFacilityType(nameSearch, facilityTypeId, pageable);
        } else {
            facilities = this.facilityService.findAllByNameContaining(nameSearch, pageable);
        }
        model.addAttribute("facilities", facilities);
        model.addAttribute("facilityTypes", this.facilityTypeService.findAll());
        model.addAttribute("facilityDTO", new FacilityDTO());
        model.addAttribute("rentTypes", this.rentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityTypeId", facilityTypeId);
        return "/facility/list";
    }

    @PostMapping("/create")
    @Transactional
    public String save(@Validated @ModelAttribute FacilityDTO facilityDTO, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model,
                       @PageableDefault(page = 0, size = 5) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String nameSearch,
                       @RequestParam(required = false, defaultValue = "0") Long facilityTypeId) {
        //X??a kho???ng tr???ng ?????u cu???i
        facilityDTO.setName(facilityDTO.getName().trim());
        if (bindingResult.hasErrors()) {
            Optional<FacilityType> facility = this.facilityTypeService.findById(facilityTypeId);
            Page<Facility> facilities;
            if (facility.isPresent()) {
                facilities = this.facilityService.findAllByNameContainingAndFacilityType(nameSearch, facilityTypeId, pageable);
            } else {
                facilities = this.facilityService.findAllByNameContaining(nameSearch, pageable);
            }
            model.addAttribute("hasErrors", "true");
            model.addAttribute("facilities", facilities);
            model.addAttribute("facilityTypes", this.facilityTypeService.findAll());
            model.addAttribute("facilityDTO", facilityDTO);
            model.addAttribute("rentTypes", this.rentTypeService.findAll());
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("facilityTypeId", facilityTypeId);
            return "/facility/list";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);

        if (this.facilityService.save(facility)) {
            redirectAttributes.addFlashAttribute("mess", "Th??m m???i d???ch v??? th??nh c??ng");
        } else {
            redirectAttributes.addFlashAttribute("mess", "T??n d???ch v??? ???? t???n t???i, th??m m???i th???t b???i");
        }
        return "redirect:/facilities";
    }

    @PostMapping("/update")
    @Transactional
    public String update(@Validated @ModelAttribute FacilityDTO facilityDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model,
                         @PageableDefault(page = 0, size = 5) Pageable pageable,
                         @RequestParam(required = false, defaultValue = "") String nameSearch,
                         @RequestParam(required = false, defaultValue = "0") Long facilityTypeId) {
        //X??a kho???ng tr???ng ?????u cu???i
        facilityDTO.setName(facilityDTO.getName().trim());
        if (bindingResult.hasErrors()) {
            Optional<FacilityType> facility = this.facilityTypeService.findById(facilityTypeId);
            Page<Facility> facilities;
            if (facility.isPresent()) {
                facilities = this.facilityService.findAllByNameContainingAndFacilityType(nameSearch, facilityTypeId, pageable);
            } else {
                facilities = this.facilityService.findAllByNameContaining(nameSearch, pageable);
            }
            model.addAttribute("hasErrors1", "true");
            model.addAttribute("facilities", facilities);
            model.addAttribute("facilityTypes", this.facilityTypeService.findAll());
            model.addAttribute("facilityDTO", facilityDTO);
            model.addAttribute("rentTypes", this.rentTypeService.findAll());
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("facilityTypeId", facilityTypeId);
            return "/facility/list";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        if (this.facilityService.update(facility)) {
            redirectAttributes.addFlashAttribute("mess", "Ch???nh s???a d???ch v??? th??nh c??ng");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Ch???nh s???a th???t b???i, d???ch v??? ch??a t???n t???i");
        }
        return "redirect:/facilities";
    }

    @PostMapping("/delete")
    @Transactional
    public String remove(@RequestParam("idDelete") Long id, RedirectAttributes redirectAttributes) {
        if (this.facilityService.remove(id)) {
            redirectAttributes.addFlashAttribute("mess", "X??a d???ch v??? th??nh c??ng");
        } else {
            redirectAttributes.addFlashAttribute("mess", "X??a kh??ng th??nh c??ng, d???ch v??? ch??a t???n t???i");
        }
        return "redirect:/facilities";
    }
}
