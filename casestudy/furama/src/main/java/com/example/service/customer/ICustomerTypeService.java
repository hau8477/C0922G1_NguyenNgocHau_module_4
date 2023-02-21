package com.example.service.customer;

import com.example.model.customer.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    Optional<CustomerType> findById(Long id);
}
