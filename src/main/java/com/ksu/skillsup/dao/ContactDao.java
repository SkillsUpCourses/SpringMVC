package com.ksu.skillsup.dao;

import com.ksu.skillsup.entities.MappedContact;
import java.util.Collection;

/**
 *
 * @author ksu
 */
public interface ContactDao {

	MappedContact selectContact(int id);
        MappedContact selectContact(String phone);
        void updateContact(MappedContact contact);
	void insertContact(MappedContact contact);
	void deleteContact(MappedContact contact);
	Collection <MappedContact> selectAllContacts();
	void clearAll();
}
