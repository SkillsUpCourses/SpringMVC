package com.mosiienko.skillsup.runner;

import com.mosiienko.skillsup.config.AppConfig;
import com.mosiienko.skillsup.models.entities.Contact;
import com.mosiienko.skillsup.services.ContactService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Class {@link SpringRunner
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
public class SpringRunner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactService contactService = context.getBean(ContactService.class);

        System.out.println(Arrays.toString(contactService.getAllContacts().toArray()));
        Contact contact = contactService.getAllContacts().get(2);
        System.out.println("\nRemoving Irina...\n");
//            Init bean by name (custom name)
        ContactService contactServiceByName = (ContactService) context.getBean("com.mosiienko.skillsup.services.ContactServiceImplbyRomanMosiienko");
        contactServiceByName.deleteContact(contact);
        System.out.println(Arrays.toString(contactServiceByName.getAllContacts().toArray()));
        System.out.println("\nClear all contacts...\n");
        contactServiceByName.clearAll();
        System.out.println(Arrays.toString(contactServiceByName.getAllContacts().toArray()));
    }
}

