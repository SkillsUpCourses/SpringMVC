package com.mosiienko.skillsup.services;

import com.mosiienko.skillsup.config.customize.Profiling;
import com.mosiienko.skillsup.models.entities.Contact;
import com.mosiienko.skillsup.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class {@link ContactServiceImpl
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
@Profiling
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public void addContact(Contact contact) {
        contactRepository.add(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }


    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getAll();
    }

    @Override
    public void clearAll() {
        contactRepository.clearAll();
    }

}
