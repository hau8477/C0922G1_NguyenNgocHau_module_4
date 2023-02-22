package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllByNameContainingAndFacilityType(String name, Long facilityTypeId, Pageable pageable);
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
    List<Facility> findAll();
    boolean save(Facility facility);
    boolean update(Facility facility);
    boolean remove(Long id);
}
