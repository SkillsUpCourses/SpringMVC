package com.mosiienko.skillsup.repositories;

import com.mosiienko.skillsup.models.entities.Contact;
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
@Transactional
public class ContactRepositoryImpl implements ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public void delete(Contact contact) {
        entityManager.remove(entityManager.contains(contact) ? contact : entityManager.merge(contact));
    }

    @Override
    public List<Contact> getAll() {
        return entityManager.createNamedQuery("getAllContacts").getResultList();
    }

    @Override
    public void clearAll() {
        entityManager.createQuery("delete from Contact").executeUpdate();
    }

}
