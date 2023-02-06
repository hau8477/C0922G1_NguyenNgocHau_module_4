package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.SmartPhone;

import java.util.List;

public interface ISmartphoneService {
    List<SmartPhone> findAll();
    boolean save(SmartPhone smartPhone);
    boolean update(SmartPhone smartPhone);
    boolean remove(int id);
    SmartPhone findById(int id);

    List<SmartPhone> search(String name);
}
