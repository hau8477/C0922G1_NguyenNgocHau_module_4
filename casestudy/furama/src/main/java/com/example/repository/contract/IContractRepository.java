package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "SELECT " +
            "       (ifnull(facility.cost, 0) + ifnull(SUM(contract_detail.quantity * attach_facility.cost), 0)) AS total_cost\n" +
            "FROM contract \n" +
            "LEFT JOIN facility ON contract.facility_id = facility.id \n" +
            "LEFT JOIN contract_detail ON contract.id = contract_detail.contract_id \n" +
            "LEFT JOIN attach_facility ON contract_detail.attach_facility_id = attach_facility.id \n" +
            "WHERE contract.id = :contractId and contract.flag = true\n" +
            "GROUP BY contract.id;", nativeQuery = true)
    double solveTotal(@Param("contractId") Long id);
    Page<Contract> findAll(Pageable pageable);
}
