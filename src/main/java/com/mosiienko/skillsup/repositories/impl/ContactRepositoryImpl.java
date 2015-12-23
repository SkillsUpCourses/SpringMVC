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
    public void delete(Contact contact) {

        entityManager.remove(entityManager.contains(contact) ? contact : entityManager.merge(contact));
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
        Session session = (Session)entityManager.getDelegate();
        Contact contact = (Contact) session.get(Contact.class, id);
        System.out.println(contact.getClass().getName());
        return contact;
    }

}
