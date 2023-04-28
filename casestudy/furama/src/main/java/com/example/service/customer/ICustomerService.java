package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, Long customerTypeId, Pageable pageable);
    Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    List<Customer> findAllByNameContainingAndEmailContaining2(String name, String email);
    List<Customer> findAllByNameContainingAndEmailContainingAndCustomerTypeId1(String name, String email, Long customerTypeId);
    List<Customer> findAllByNameContainingAndEmailContaining1(String name, String email, Pageable pageable);

    List<Customer> findAll();


    boolean save(Customer customer);

    boolean update(Customer customer);

    Optional<Customer> findById(Long id);
    Optional<Customer> findByIdCard(String idCard);

    boolean removeById(Long id);
}
