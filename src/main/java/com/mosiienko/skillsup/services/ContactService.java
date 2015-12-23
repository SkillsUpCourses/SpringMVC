package com.mosiienko.skillsup.services;

import com.mosiienko.skillsup.models.dto.ContactDto;

import java.util.List;

/**
 * Class {@link ContactService
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
public interface ContactService {
    void add(ContactDto contactDto);
    void delete(ContactDto contactDto);
    List<ContactDto> getAll();
    void clearAll();
    ContactDto getById(int id);
}
