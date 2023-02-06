package com.example.productmanagementthymeleaf.service.impl;

import com.example.productmanagementthymeleaf.model.SmartPhone;
import com.example.productmanagementthymeleaf.repository.ISmartphoneRepository;
import com.example.productmanagementthymeleaf.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;
    @Override
    public List<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public boolean save(SmartPhone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public boolean update(SmartPhone smartPhone) {
        return smartphoneRepository.update(smartPhone);
    }

    @Override
    public boolean remove(int id) {
       return smartphoneRepository.remove(id);
    }

    @Override
    public SmartPhone findById(int id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public List<SmartPhone> search(String name) {
        return smartphoneRepository.search(name);
    }
}
