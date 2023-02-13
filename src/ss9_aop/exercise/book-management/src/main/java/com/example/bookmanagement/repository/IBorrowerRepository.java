package com.example.bookmanagement.repository;


import com.example.bookmanagement.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBorrowerRepository extends JpaRepository<Borrower, Long> {

    @Query(value = "select * from borrower where code = :code1", nativeQuery = true)
    Borrower findByCode(@Param("code1") String code);
}
