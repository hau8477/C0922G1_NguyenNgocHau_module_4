package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, Long customerTypeId, Pageable pageable) {
        return this.customerRepository.findAllByNameContainingAndEmailContainingAndCustomerType_Id(
                 name,email,customerTypeId,pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable) {
        return this.customerRepository.findAllByNameContainingAndEmailContaining(
                name,email,pageable);
    }

    @Override
    public boolean save(Customer customer) {
        this.customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        this.customerRepository.save(customer);
        return true;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public boolean removeById(Long id) {
        this.customerRepository.deleteById(id);
        return true;
    }
}
