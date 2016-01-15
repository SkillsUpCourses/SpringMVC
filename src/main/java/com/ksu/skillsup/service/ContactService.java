package com.ksu.skillsup.service;

import com.ksu.skillsup.models.Contact;
import java.util.Collection;

public interface ContactService {

	Contact getContact(int id);
	Contact getContact(String phone);
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);
	Collection<Contact> getAllContacts(); 
        void clearAll();	
}
