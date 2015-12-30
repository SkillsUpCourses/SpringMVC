package com.mosiienko.skillsup.repositories;

import com.mosiienko.skillsup.models.entities.Contact;

import java.util.List;

/**
 * Class {@link ContactRepository
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
public interface ContactRepository {
    void save(Contact contact);
    void delete(int id);
    List<Contact> selectAll();
    void dropTable();
    Contact selectById(int id);
}
