package com.example.service.facility.impl;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.IFacilityTypeRepository;
import com.example.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return this.facilityTypeRepository.findAll();
    }

    @Override
    public Optional<FacilityType> findById(Long id) {
        return this.facilityTypeRepository.findById(id);
    }
}
