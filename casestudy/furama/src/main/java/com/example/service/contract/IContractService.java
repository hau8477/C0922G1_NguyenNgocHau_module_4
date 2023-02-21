package com.example.service.contract;

import com.example.dto.ContractDTO;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IContractService {
    List<ContractDTO> findAll();

}
