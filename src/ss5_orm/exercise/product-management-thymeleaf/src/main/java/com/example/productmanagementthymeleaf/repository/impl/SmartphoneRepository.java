package com.example.productmanagementthymeleaf.repository.impl;

import com.example.productmanagementthymeleaf.model.SmartPhone;
import com.example.productmanagementthymeleaf.repository.ConnectionUtil;
import com.example.productmanagementthymeleaf.repository.ISmartphoneRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Component
public class SmartphoneRepository implements ISmartphoneRepository {


    @Override
    public List<SmartPhone> findAll() {
        List<SmartPhone> smartPhones = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        smartPhones = session.createQuery("FROM SmartPhone ").getResultList();
        session.close();
        return smartPhones;
    }

    @Override
    public boolean save(SmartPhone smartPhone) {
        Transaction transaction = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(smartPhone);
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean update(SmartPhone smartPhone) {
        SmartPhone smartPhone1 = findById(smartPhone.getId());
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            smartPhone1.setName(smartPhone.getName());
            smartPhone1.setBrand(smartPhone.getBrand());
            smartPhone1.setPrice(smartPhone.getPrice());
            session.update(smartPhone1);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        SmartPhone smartPhone = findById(id);
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(smartPhone);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null || smartPhone == null) {
                assert transaction != null;
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public SmartPhone findById(int id) {
        SmartPhone smartPhone;
        Session session = ConnectionUtil.sessionFactory.openSession();
        smartPhone = (SmartPhone) session.createQuery("FROM SmartPhone WHERE id = :id").setParameter("id", id).getSingleResult();
        session.close();
        return smartPhone;
    }

    @Override
    public List<SmartPhone> search(String name) {
        List<SmartPhone> phones = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            TypedQuery<SmartPhone> query = session.createQuery("SELECT s FROM SmartPhone s WHERE s.name LIKE :name").setParameter("name", "%" + name + "%");
            phones = query.getResultList();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
        }
        return phones;
    }
}
