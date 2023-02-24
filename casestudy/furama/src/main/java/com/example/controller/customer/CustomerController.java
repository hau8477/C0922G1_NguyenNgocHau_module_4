package com.example.controller.customer;

import com.example.dto.customerdto.CustomerDTO;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
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
        Optional<CustomerType> customerType = this.customerTypeService.findById(customerTypeId);
        Page<Customer> customers;
        if (customerType.isPresent()) {
            customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
                    nameSearch, emailSearch, customerTypeId, pageable);
        } else {
            customers = this.customerService.findAllByNameContainingAndEmailContaining(
                    nameSearch, emailSearch, pageable);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeId", customerTypeId);
        return "/customer/list";
    }

    @PostMapping("/create")
    @Transactional
    public String save(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult,
                       @RequestParam(required = false, defaultValue = "") String nameSearch,
                       @RequestParam(required = false, defaultValue = "") String emailSearch,
                       @RequestParam(required = false, defaultValue = "0") Long customerTypeId,
                       @PageableDefault(page = 0, size = 5)Pageable pageable,
                       Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            Optional<CustomerType> customerType = this.customerTypeService.findById(customerTypeId);
            Page<Customer> customers;
            if (customerType.isPresent()) {
                customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
                        nameSearch, emailSearch, customerTypeId, pageable);
            } else {
                customers = this.customerService.findAllByNameContainingAndEmailContaining(
                        nameSearch, emailSearch, pageable);
            }
            model.addAttribute("hasErrors","true");
            model.addAttribute("customers", customers);
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            model.addAttribute("customerDTO", customerDTO);
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("emailSearch", emailSearch);
            model.addAttribute("customerTypeId", customerTypeId);
            return "/customer/list";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);

        if(this.customerService.save(customer)){
            redirectAttributes.addFlashAttribute("mess","Thêm mới khách hàng thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess","Thông tin khách hàng đã tồn tại");
        }
        return "redirect:/customers/";
    }

    @PostMapping("/update")
    @Transactional
    public String update(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult,
                         @RequestParam(required = false, defaultValue = "") String nameSearch,
                         @RequestParam(required = false, defaultValue = "") String emailSearch,
                         @RequestParam(required = false, defaultValue = "0") Long customerTypeId,
                         @PageableDefault(page = 0, size = 5)Pageable pageable,
                         Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            Optional<CustomerType> customerType = this.customerTypeService.findById(customerTypeId);
            Page<Customer> customers;
            if (customerType.isPresent()) {
                customers = this.customerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
                        nameSearch, emailSearch, customerTypeId, pageable);
            } else {
                customers = this.customerService.findAllByNameContainingAndEmailContaining(
                        nameSearch, emailSearch, pageable);
            }
            model.addAttribute("hasErrors","true");
            model.addAttribute("customers", customers);
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            model.addAttribute("customerDTO", customerDTO);
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("emailSearch", emailSearch);
            model.addAttribute("customerTypeId", customerTypeId);
            return "/customer/list";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        if(this.customerService.update(customer)){
            redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thất bại");
        }
        return "redirect:/customers/";
    }
    @PostMapping("/delete")
    @Transactional
    public String delete(@RequestParam("idDelete") Long id, RedirectAttributes redirectAttributes){
        if(this.customerService.removeById(id)){
            redirectAttributes.addFlashAttribute("mess","Xóa khách hàng thành công");
        }else {
            redirectAttributes.addFlashAttribute("mess","Xóa khách hàng thất bại");
        }
        return "redirect:/customers/";
    }
}