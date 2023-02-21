package com.example.service.contract;

import com.example.dto.ContractDetailDTO;
import com.example.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetailDTO> getContractDetailsDTOByContractId(Long contractId);
    boolean save(ContractDetail contractDetail);
}
