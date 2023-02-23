package com.example.service.contract.impl;

import com.example.dto.contractdto.ContractDetailDTO;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IAttachFacilityRepository;
import com.example.repository.contract.IContractDetailRepository;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<ContractDetailDTO> getContractDetailsDTOByContractId(Long contractId) {
        return this.contractDetailRepository.getContractDetailsDTOByContractId(contractId);
    }

    @Override
    public boolean save(ContractDetail contractDetail) {
        Optional<Contract> contract = this.contractRepository.findById(contractDetail.getContract().getId());
        Optional<AttachFacility> attachFacility = this.attachFacilityRepository.findById(contractDetail.getAttachFacility().getId());

        if(contractDetail.getQuantity() <= 0 || !contract.isPresent() || !attachFacility.isPresent()){
            return false;
        }

        this.contractDetailRepository.save(contractDetail);
        return true;
    }
}
