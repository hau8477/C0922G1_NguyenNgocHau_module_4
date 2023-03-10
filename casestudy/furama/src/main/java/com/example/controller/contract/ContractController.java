package com.example.controller.contract;

import com.example.dto.contractdto.ContractDetailRequestDTO;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.facility.IFacilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public String findAll(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        model.addAttribute("attachFacilities", this.attachFacilityService.findAllAttachFacility());
        model.addAttribute("contractDTOS", this.contractService.findAll(pageable));
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractNew", new Contract());
        model.addAttribute("customers", this.customerService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        model.addAttribute("facilities", this.facilityService.findAll());
        return "/contract/list";
    }

    @PostMapping("/create")
    @ResponseBody
    @Transactional
    public Map<String, String> createContract(@RequestBody Map<String, Object> requestData) {
        Map<String, String> response = new HashMap<>();

        // L???y ?????i t?????ng Contract t??? requestData
        ObjectMapper mapper = new ObjectMapper();
        Contract contract = mapper.convertValue(requestData.get("contract"), Contract.class);

        // L???y danh s??ch ContractDetail t??? requestData
        List<Map<String, Object>> contractDetailsData = (List<Map<String, Object>>) requestData.get("contractDetails");

        List<ContractDetailRequestDTO> contractDetailRequestDTOS = new ArrayList<>();
        for (Map<String, Object> detailData : contractDetailsData) {
            ContractDetailRequestDTO detail = mapper.convertValue(detailData, ContractDetailRequestDTO.class);
            contractDetailRequestDTOS.add(detail);
        }
        // L??u Contract v?? ContractDetail
        if (contractService.saveContract(contract, contractDetailRequestDTOS)) {
            response.put("mess", "T???o h???p ?????ng th??nh c??ng");
        } else {
            response.put("mess", "T???o h???p ?????ng th???t b???i");
        }
        return response;
    }
}
