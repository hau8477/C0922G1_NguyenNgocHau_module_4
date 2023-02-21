package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAllByNameContainingAndFacilityType(String name, Long facilityTypeId, Pageable pageable) {
        return this.facilityRepository.findAllByNameContainingAndFacilityType_Id(name,facilityTypeId,pageable);
    }

    @Override
    public Page<Facility> findAllByNameContaining(String name, Pageable pageable) {
        return this.facilityRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public boolean save(Facility facility) {
        Optional<Facility> optionalFacility = this.facilityRepository.findByName(facility.getName());
        if (optionalFacility.isPresent()){
            return false;
        }
        this.facilityRepository.save(facility);
        return true;
    }

    @Override
    public boolean update(Facility facility) {
        Optional<Facility> optionalFacility = this.facilityRepository.findById(facility.getId());
        if(!optionalFacility.isPresent()){
            return false;
        }
        this.facilityRepository.save(facility);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        Optional<Facility> optionalFacility = this.facilityRepository.findById(id);
        if(!optionalFacility.isPresent()){
            return false;
        }
        this.facilityRepository.deleteById(id);
        return true;
    }
}
