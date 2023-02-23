package com.example.service.contract;

import com.example.dto.contractdto.ContractDTO;
import com.example.dto.contractdto.ContractDetailRequestDTO;
import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<ContractDTO> findAll(Pageable pageable);

    boolean saveContract(Contract contract, List<ContractDetailRequestDTO> contractDetailRequestDTOS);
}
