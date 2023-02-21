package com.example.controller.contract;

import com.example.dto.ContractDetailDTO;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/attach-facilities/{id}")
    public ResponseEntity<List<ContractDetailDTO>> solveTotal(@PathVariable Long id) {
        List<ContractDetailDTO> attachFacilityDTOS = this.contractDetailService.getContractDetailsDTOByContractId(id);
        if (attachFacilityDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityDTOS, HttpStatus.OK);
    }
}
