package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.SmartPhone;

import java.util.List;

public interface ISmartphoneService {
    List<SmartPhone> findAll();
    void save(SmartPhone smartPhone);
    void update(SmartPhone smartPhone);
    void remove(int id);
    SmartPhone findById(int id);
}
