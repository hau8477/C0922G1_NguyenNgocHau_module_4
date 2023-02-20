package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, Long customerTypeId, Pageable pageable);
    Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable);


    boolean save(Customer customer);

    boolean update(Customer customer);

    Optional<Customer> findById(Long id);
    Optional<Customer> findByIdCard(String idCard);

    boolean removeById(Long id);
}
