package com.example.controller.customer;

import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String findAllCustomer(
            @RequestParam(required = false, defaultValue = "") String nameSearch,
            @RequestParam(required = false, defaultValue = "") String emailSearch,
            @RequestParam(required = false, defaultValue = "0") Long customerTypeId,
            @PageableDefault(page = 0, size = 5)Pageable pageable,
            Model model){
        Page<Customer> customers;
        if (customerTypeId == 0) {
            customers = this.customerService.findAllByNameContainingAndEmailContaining(
                    nameSearch, emailSearch, pageable);
        } else {
            customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
                    nameSearch, emailSearch, customerTypeId, pageable);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "/customer/list";
    }
}
