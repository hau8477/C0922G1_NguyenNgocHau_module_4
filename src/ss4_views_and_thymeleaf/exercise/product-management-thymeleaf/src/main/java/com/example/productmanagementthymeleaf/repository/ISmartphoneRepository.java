package com.example.productmanagementthymeleaf.repository;

import com.example.productmanagementthymeleaf.model.SmartPhone;

import java.util.List;

public interface ISmartphoneRepository {
    List<SmartPhone> findAll();

    void save(SmartPhone smartPhone);

    void update(SmartPhone smartPhone);

    void remove(int id);

    SmartPhone findById(int id);

    List<SmartPhone> search(String name);
}
