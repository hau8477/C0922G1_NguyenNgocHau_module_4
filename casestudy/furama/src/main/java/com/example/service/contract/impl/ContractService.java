package com.example.service.contract.impl;

import com.example.dto.ContractDTO;
import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<ContractDTO> findAll(Pageable pageable) {
        Page<Contract> contract1 = this.contractRepository.findAll(pageable);
        Pageable newPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        List<Contract> contracts = contract1.getContent();
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for (Contract contract : contracts) {
            ContractDTO contractDTO = new ContractDTO();
            BeanUtils.copyProperties(contract, contractDTO);
            contractDTO.setTotalCost(this.contractRepository.solveTotal(contract.getId()));
            contractDTOS.add(contractDTO);
        }
        Page<ContractDTO> contractDTOPage = new PageImpl<>(contractDTOS, newPageable, contract1.getTotalElements());
        return contractDTOPage;
    }

}
