package com.mosiienko.skillsup.runner;

import com.mosiienko.skillsup.config.AppConfig;
import com.mosiienko.skillsup.lookup.ColorFrame;
import com.mosiienko.skillsup.models.Contact;
import com.mosiienko.skillsup.services.ContactService;
import com.mosiienko.skillsup.services.ContactServiceImpl;
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

        while (true) {
            Thread.sleep(100);
            context.getBean(ColorFrame.class).showOnRandomPlace();
//            System.out.println(Arrays.toString(contactService.getAllContacts().toArray()));
//            Contact contact = contactService.getAllContacts().get(2);
//            System.out.println("\nRemoving Irina...\n");
            //Init bean by name (custom name)
//            ContactService contactServiceByName = (ContactService) context.getBean("com.mosiienko.skillsup.services.ContactServiceImplbyRomanMosiienko");
//            contactServiceByName.deleteContact(contact);
//            System.out.println(Arrays.toString(contactServiceByName.getAllContacts().toArray()));
        }
    }
}
