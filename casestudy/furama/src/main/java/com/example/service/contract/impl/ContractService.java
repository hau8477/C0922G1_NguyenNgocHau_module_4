package com.example.service.contract.impl;

import com.example.dto.ContractDTO;
import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<ContractDTO> findAll() {
        List<Contract> contracts = this.contractRepository.findAll();
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for (Contract contract:contracts) {
            ContractDTO contractDTO = new ContractDTO();
            BeanUtils.copyProperties(contract,contractDTO);
            contractDTO.setTotalCost(this.contractRepository.solveTotal(contract.getId()));
            contractDTOS.add(contractDTO);
        }
        return contractDTOS;
    }

}
