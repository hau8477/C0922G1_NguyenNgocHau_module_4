package com.example.service.contract.impl;

import com.example.repository.contract.IAttachFacilityRepository;
import com.example.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacility implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<com.example.model.contract.AttachFacility> findAll() {
        return this.attachFacilityRepository.findAll();
    }
}
