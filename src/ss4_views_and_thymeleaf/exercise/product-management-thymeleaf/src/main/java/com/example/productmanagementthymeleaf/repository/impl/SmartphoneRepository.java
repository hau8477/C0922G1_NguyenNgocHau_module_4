package com.example.productmanagementthymeleaf.repository.impl;

import com.example.productmanagementthymeleaf.model.SmartPhone;
import com.example.productmanagementthymeleaf.repository.ISmartphoneRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class SmartphoneRepository implements ISmartphoneRepository {
    private static final Map<Integer, SmartPhone> smartPhones = new HashMap<>();

    static {
        smartPhones.put(1, new SmartPhone(1, "IPhone X", "Apple", 1000));
        smartPhones.put(2, new SmartPhone(2, "IPhone 6", "Apple", 500));
        smartPhones.put(3, new SmartPhone(3, "IPhone 7", "Apple", 600));
        smartPhones.put(4, new SmartPhone(4, "IPhone 8", "Apple", 700));
        smartPhones.put(5, new SmartPhone(5, "IPhone 11", "Apple", 2000));
        smartPhones.put(6, new SmartPhone(6, "IPhone 12", "Apple", 3000));
        smartPhones.put(7, new SmartPhone(7, "IPhone 13", "Apple", 4000));
        smartPhones.put(8, new SmartPhone(8, "IPhone 13 Promax", "Apple", 5000));
        smartPhones.put(9, new SmartPhone(9, "IPhone 14", "Apple", 6000));
        smartPhones.put(10, new SmartPhone(10, "IPhone 14 Promax", "Apple", 7000));
    }

    @Override
    public List<SmartPhone> findAll() {
        return new ArrayList<>(smartPhones.values());
    }

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhones.put(smartPhone.getId(), smartPhone);
    }

    @Override
    public void update(SmartPhone smartPhone) {
        smartPhones.put(smartPhone.getId(), smartPhone);
    }

    @Override
    public void remove(int id) {
        smartPhones.remove(id);
    }

    @Override
    public SmartPhone findById(int id) {
        return smartPhones.get(id);
    }

    @Override
    public List<SmartPhone> search(String name) {
        List<SmartPhone> phones = new ArrayList<>(smartPhones.values());
        List<SmartPhone> smartPhones1 = new ArrayList<>();
        for (SmartPhone phone : phones) {
            if (phone.getName().contains(name)) {
                smartPhones1.add(phone);
            }
        }
        return smartPhones1;
    }
}
