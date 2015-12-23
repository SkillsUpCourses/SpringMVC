package com.mosiienko.skillsup.services.impl;

import com.mosiienko.skillsup.config.customize.Profiling;
import com.mosiienko.skillsup.models.dto.ContactDto;
import com.mosiienko.skillsup.models.entities.Contact;
import com.mosiienko.skillsup.repositories.ContactRepository;
import com.mosiienko.skillsup.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link ContactServiceImpl
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
@Transactional
@PropertySource("classpath:persistence_config.properties")
@Profiling
@Service
public class ContactServiceImpl implements ContactService {

    @Value("${size.max:0}")
    public String maxContactSize;

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public void add(ContactDto contactDto) {
        if(contactRepository.selectAll().size()<Integer.valueOf(maxContactSize)) {
            Contact contact = new Contact().setName(contactDto.getName()).setAge(contactDto.getAge()).setPhone(contactDto.getPhone()).setSecondName(contactDto.getSecondName());
            contactRepository.save(contact);
        }
    }

    @Override
    public void delete(ContactDto contactDto) {
        Contact contact = new Contact().setName(contactDto.getName()).setAge(contactDto.getAge()).setPhone(contactDto.getPhone()).setSecondName(contactDto.getSecondName()).setId(contactDto.getId());
        contactRepository.delete(contact);
    }


    @Override
    public List<ContactDto> getAll() {
        ArrayList<ContactDto> contactDtoList = new ArrayList<>();
        for (Contact contact : contactRepository.selectAll()) {
            ContactDto contactDto = new ContactDto(contact.getName(), contact.getSecondName(), contact.getAge(), contact.getPhone(),contact.getId());
            contactDtoList.add(contactDto);
        }
        return contactDtoList;
    }

    @Override
    public void clearAll() {
        contactRepository.dropTable();
    }

    @Override
    public ContactDto getById(int id) {
        Contact contact = contactRepository.selectById(id);
        return new ContactDto(contact.getName(), contact.getSecondName(), contact.getAge(), contact.getPhone(),contact.getId());
    }

}
