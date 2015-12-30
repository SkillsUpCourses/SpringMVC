package com.mosiienko.skillsup.repositories.impl;

import com.mosiienko.skillsup.models.entities.Contact;
import com.mosiienko.skillsup.repositories.ContactRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class {@link ContactRepositoryImpl
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public void delete(int id) {
        entityManager.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Contact> selectAll() {
        return entityManager.createNamedQuery("getAll").getResultList();
    }

    @Override
    public void dropTable() {
        entityManager.createNativeQuery("truncate table contacts").executeUpdate();
    }

    @Override
    public Contact selectById(int id) {
        return (Contact) entityManager.createNamedQuery("getById").setParameter("id", id).getSingleResult();
    }

}
