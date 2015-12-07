package com.mosiienko.skillsup.services;

import com.mosiienko.skillsup.models.Contact;

import java.util.List;

/**
 * Class {@link ContactService
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
public interface ContactService {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    List<Contact> getAllContacts();
    void cleatAll();
}
