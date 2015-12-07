package com.mosiienko.skillsup.repositories;

import com.mosiienko.skillsup.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link ContactRepositoryImpl
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
@PropertySource("classpath:default_data_of_contacts.properties")
@Repository
public class ContactRepositoryImpl implements ContactRepository {
    @Autowired
    private Environment env;
    private List<Contact> source;
    private int idGenerator;

    @Override
    public void add(Contact contact) {
        contact.setId(idGenerator++);
        source.add(contact);
    }

    @Override
    public void delete(Contact contact) {
        source.remove(contact);
    }

    @Override
    public List<Contact> getAll() {
        return source;
    }

    @Override
    public void cleatAll() {
        source.clear();
        idGenerator = 0;
    }

    @PostConstruct
    private void initSource() {
        source = new ArrayList<>();
        String[] idsOfUsersFromProperties = {"alex", "serg", "ira"};
        for (String id : idsOfUsersFromProperties) {
            String name = env.getProperty("name." + id);
            String secondName = env.getProperty("secondname." + id);
            String age = env.getProperty("age." + id);
            String phone = env.getProperty("phone." + id);
            source.add(new Contact().setId(idGenerator++).setName(name).setSecondName(secondName).setAge(Integer.parseInt(age)).setPhone(phone));
        }
    }
}
