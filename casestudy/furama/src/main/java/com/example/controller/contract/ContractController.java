package com.example.controller.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String findAll(Model model, @PageableDefault(page = 0, size = 5)Pageable pageable) {
        model.addAttribute("attachFacilities", this.attachFacilityService.findAllAttachFacility());
        model.addAttribute("contractDTOS", this.contractService.findAll(pageable));
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractNew", new Contract());
        model.addAttribute("customers", this.customerService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        model.addAttribute("facilities", this.facilityService.findAll());
        return "/contract/list";
    }
}
