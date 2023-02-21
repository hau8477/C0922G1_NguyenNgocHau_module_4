package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where name like concat('%',:name,'%') and email like " +
            "concat('%',:email,'%') and customer_type_id = :customerTypeId and flag=true", nativeQuery = true)
    Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(@Param("name") String name,
                           @Param("email") String email,
                           @Param("customerTypeId") Long customerTypeId,
                           Pageable pageable);
    @Query(value = "select * from customer where name like concat('%',:name,'%') and email like " +
            "concat('%',:email,'%') and flag=true", nativeQuery = true)
    Page<Customer> findAllByNameContainingAndEmailContaining(@Param("name") String name,
                           @Param("email") String email,
                           Pageable pageable);
    Optional<Customer> findByIdCard(String idCard);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
    @Query(value = "select * from customer where id_card = :idCard or email = :email or phone_number = :phoneNumber " +
            "and flag = true",
    nativeQuery = true)
    Optional<Customer> findCustomerByIdCardOrEmailOrPhoneNumber(
            @Param("idCard") String idCard,@Param("email") String email,@Param("phoneNumber") String phoneNumber);
}
