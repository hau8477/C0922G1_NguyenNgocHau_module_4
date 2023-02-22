package com.example.controller.contract;

import com.example.model.contract.ContractDetail;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @PostMapping("/save-contract-detail")
    public String save(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        if (this.contractDetailService.save(contractDetail)) {
            redirectAttributes.addFlashAttribute("mess", "Thêm mới dịch vụ đi kèm thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Thêm mới dịch vụ đi kèm thất bại");
        }
        return "redirect:/contracts/";
    }
}
