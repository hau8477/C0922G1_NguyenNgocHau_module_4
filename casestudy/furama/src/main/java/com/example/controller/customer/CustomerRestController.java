package com.example.controller.customer;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll(@RequestParam(required = false, defaultValue = "") String nameSearch,
                                                  @RequestParam(required = false, defaultValue = "") String emailSearch,
                                                  @RequestParam(required = false, defaultValue = "0") Long customerTypeId) {
        CustomerType customerType = this.customerTypeService.findById(customerTypeId).orElse(null);
        List<Customer> customers;
        if (customerType != null) {
            customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerTypeId1(
                    nameSearch, emailSearch, customerTypeId);
        } else {
            customers = this.customerService.findAllByNameContainingAndEmailContaining2(
                    nameSearch, emailSearch);
        }
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable long id) {
        if (this.customerService.removeById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
