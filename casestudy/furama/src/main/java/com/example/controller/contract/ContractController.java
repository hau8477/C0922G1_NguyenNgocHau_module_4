package com.example.controller.contract;

import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("attachFacilities", this.attachFacilityService.findAll());
        model.addAttribute("contractDTOS", this.contractService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/list";
    }
}
