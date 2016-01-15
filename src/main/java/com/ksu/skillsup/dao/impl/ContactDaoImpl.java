package com.ksu.skillsup.dao.impl;

import com.ksu.skillsup.dao.ContactDao;
import com.ksu.skillsup.entities.MappedContact;
import com.ksu.skillsup.models.Contact;
import com.ksu.skillsup.models.Hobby;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ksu
 */

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly=false)
    public void insertContact(MappedContact contact) {
       em.persist(contact); 
    }

    @Override
    @Transactional(readOnly=false)
    public void updateContact(MappedContact contact) {
        Contact old = em.find(Contact.class, contact.getID());
        old.setFirstName(contact.getFirstName());
        old.setLastName(contact.getLastName());
        old.setPhone(contact.getPhone());
        old.setEmail(contact.getEmail());
        old.setHobby(new Hobby(contact.getHobby()));
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteContact(MappedContact contact) {
        em.remove(contact);
    }

    @Override
    @Transactional(readOnly=true)
    public MappedContact selectContact(String phone) {
         return em.find(MappedContact.class, phone);
    }

    @Override
    @Transactional(readOnly=true)
    public MappedContact selectContact(int number) {
        return em.find(MappedContact.class, number);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<MappedContact> selectAllContacts() {
        return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }

    @Override
    @Transactional(readOnly=false)
    public void clearAll() {
        em.clear();
    }
    
}
