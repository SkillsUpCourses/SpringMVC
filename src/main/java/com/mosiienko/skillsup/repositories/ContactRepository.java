package com.mosiienko.skillsup.repositories;

import com.mosiienko.skillsup.models.Contact;

import java.util.List;

/**
 * Class {@link ContactRepository
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
public interface ContactRepository {
    void add(Contact contact);
    void delete(Contact contact);
    List<Contact> getAll();
    void cleatAll();
}
