package com.example.service.contract.impl;

import com.example.dto.contractdto.ContractDTO;
import com.example.dto.contractdto.ContractDetailRequestDTO;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.repository.contract.IAttachFacilityRepository;
import com.example.repository.contract.IContractDetailRepository;
import com.example.repository.contract.IContractRepository;
import com.example.repository.customer.ICustomerRepository;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IEmployeeRepository employeeRepository;

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

    @Override
    @Transactional
    public boolean saveContract(Contract contract, List<ContractDetailRequestDTO> contractDetails) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(contract.getCustomer().getId());
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(contract.getEmployee().getId());

        if (!optionalCustomer.isPresent() || !optionalEmployee.isPresent()) {
            return false;
        }

        if(contract.getDeposit() < 0){
            System.err.println("Tiền đặt cọc phải là số dương");
            return false;
        }

        for (ContractDetailRequestDTO contractDetailRequestDTO : contractDetails) {
            if(contractDetailRequestDTO.getQuantity() <= 0){
                System.err.println("Số lượng của dịch vụ đi kèm nhỏ hơn 1");
                return false;
            }

            Optional<AttachFacility> attachFacility =
                    this.attachFacilityRepository.findById(contractDetailRequestDTO.getId());

            if (!attachFacility.isPresent()) {
                System.err.println("Attach facility không tồn tại");
                return false;
            }
        }

        this.contractRepository.save(contract);

        for (ContractDetailRequestDTO contractDetailRequestDTO : contractDetails) {
            Optional<AttachFacility> attachFacility =
                    this.attachFacilityRepository.findById(contractDetailRequestDTO.getId());

            ContractDetail contractDetailNew = new ContractDetail();
            contractDetailNew.setContract(contract);
            contractDetailNew.setAttachFacility(attachFacility.get());
            contractDetailNew.setQuantity(contractDetailRequestDTO.getQuantity());

            this.contractDetailRepository.save(contractDetailNew);
        }
        return true;
    }

//    @Override
//    @Transactional
//    public boolean saveContract(Contract contract, List<ContractDetailRequestDTO> contractDetails) {
//        Customer customer = customerRepository.findById(contract.getCustomer().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Khách hàng không tồn tại"));
//        Employee employee = employeeRepository.findById(contract.getEmployee().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Nhân viên không tồn tại"));
//
//        List<AttachFacility> attachFacilities = attachFacilityRepository.findAllById(
//                contractDetails.stream().map(ContractDetailRequestDTO::getId).collect(Collectors.toList())
//        );
//        Map<Long, AttachFacility> attachFacilityMap = attachFacilities.stream()
//                .collect(Collectors.toMap(AttachFacility::getId, Function.identity()));
//
//        boolean isInvalidContractDetails = contractDetails.stream()
//                .anyMatch(detail -> !attachFacilityMap.containsKey(detail.getId()) || detail.getQuantity() <= 0);
//
//        if (isInvalidContractDetails) {
//            throw new IllegalArgumentException("Attach facility không tồn tại hoặc số lượng nhỏ hơn 0");
//        }
//
//        contract.setCustomer(customer);
//        contract.setEmployee(employee);
//        contractRepository.save(contract);
//
//        List<ContractDetail> contractDetailsNew = contractDetails.stream()
//                .map(detail -> {
//                    ContractDetail contractDetail = new ContractDetail();
//                    contractDetail.setContract(contract);
//                    contractDetail.setAttachFacility(attachFacilityMap.get(detail.getId()));
//                    contractDetail.setQuantity(detail.getQuantity());
//                    return contractDetail;
//                })
//                .collect(Collectors.toList());
//
//        contractDetailRepository.saveAll(contractDetailsNew);
//        return true;
//    }

}
