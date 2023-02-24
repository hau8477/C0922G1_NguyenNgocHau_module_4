package com.example.controller.contract;

import com.example.dto.contractdto.ContractDetailDTO;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contracts")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/attach-facilities/{id}")
    public ResponseEntity<List<ContractDetailDTO>> findAllContractDetail(@PathVariable Long id) {
        List<ContractDetail> contractDetailList = this.contractDetailService.getContractDetailsByContractId(id);
        List<ContractDetailDTO> contractDetailDTOS = new ArrayList<>();
        for (ContractDetail contractDetail :contractDetailList) {
            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
            contractDetailDTO.setAttachFacilityName(contractDetail.getAttachFacility().getName());
            contractDetailDTO.setContractId(contractDetail.getContract().getId());
            contractDetailDTO.setQuantity(contractDetail.getQuantity());
            contractDetailDTOS.add(contractDetailDTO);
        }
        if (contractDetailDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailDTOS, HttpStatus.OK);
    }
}
