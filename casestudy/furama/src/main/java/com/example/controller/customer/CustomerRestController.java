//package com.example.controller.customer;
//
//import com.example.model.customer.Customer;
//import com.example.service.customer.ICustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@CrossOrigin("*")
//public class CustomerRestController {
//    @Autowired
//    private ICustomerService customerService;
//
//    @GetMapping("/customer")
//    public ResponseEntity<Page<Customer>> findAllCustomer(
//            @RequestParam(required = false, defaultValue = "") String nameSearch,
//            @RequestParam(required = false, defaultValue = "") String emailSearch,
//            @RequestParam(required = false, defaultValue = "0") Long customerTypeId,
//            @RequestParam(required = false, defaultValue = "0") int page) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<Customer> customers;
//        if (customerTypeId == 0) {
//            customers = this.customerService.findAllByNameContainingAndEmailContaining(
//                    nameSearch, emailSearch, pageable);
//        } else {
//            customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
//                    nameSearch, emailSearch, customerTypeId, pageable);
//        }
//        assert customers != null;
//        if (customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(customers, HttpStatus.OK);
//        }
//    }
//}
