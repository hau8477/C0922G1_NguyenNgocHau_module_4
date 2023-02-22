package com.example.repository.contract;

import com.example.dto.ContractDetailDTO;
import com.example.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {

    @Query(value = "SELECT attach_facility.name, contract.id, contract_detail.quantity \n" +
            "FROM contract_detail \n" +
            " JOIN attach_facility ON contract_detail.attach_facility_id = attach_facility.id \n" +
            " JOIN contract ON contract_detail.contract_id = contract.id \n" +
            "WHERE contract_detail.contract_id = :contractId and contract.flag = true", nativeQuery = true)
    List<Object[]> findContractDetailsByContractId(@Param("contractId") Long contractId);

     default List<ContractDetailDTO> getContractDetailsDTOByContractId(Long contractId) {
        List<Object[]> results = findContractDetailsByContractId(contractId);
         List<ContractDetailDTO> contractDetails = new ArrayList<>();
         for (Object[] result : results) {
             String attachFacilityName = (String) result[0];
             Number contractId1 = (Number) result[1];
             Number quantity = (Number) result[2];
             ContractDetailDTO dto = new ContractDetailDTO(attachFacilityName, contractId1.longValue(), quantity.intValue());
             contractDetails.add(dto);
         }
        return contractDetails;
    }
}