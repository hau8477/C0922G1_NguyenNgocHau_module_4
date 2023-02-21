package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findAllByNameContainingAndFacilityType(String name, Long facilityTypeId, Pageable pageable);
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
    boolean save(Facility facility);
    boolean update(Facility facility);
    boolean remove(Long id);
}
