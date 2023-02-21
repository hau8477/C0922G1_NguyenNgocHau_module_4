package com.example.service.facility;

import com.example.model.facility.FacilityType;

import java.util.List;
import java.util.Optional;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
    Optional<FacilityType> findById(Long id);
}
