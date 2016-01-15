package com.ksu.skillsup.controllers;

import com.ksu.skillsup.models.Contact;
import com.ksu.skillsup.entities.MappedContact;
import com.ksu.skillsup.service.ContactService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;


/**
 * Class {@link ContactController}
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 30.12.15
 */
@RequestMapping(value = "/contacts")
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value = "/allcontacts" , method = RequestMethod.GET)
    @ResponseBody
    public String getAllContacts(ModelMap model) {
        Collection<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "redirect:/views/allcontacts.jsp";
    }


   @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newContact(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		model.addAttribute("edit", false);
		return "registration";
	}
        
        @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveContact(@Valid Contact contact, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "registration";
		}
                contactService.addContact(contact);

		model.addAttribute("success", "Contact " + contact.getFirstName()+ " registered successfully");
		return "success";
        }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    @ResponseBody
    public Collection<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteContact(@PathVariable(value = "id") int id) {
         contactService.deleteContact(contactService.getContact(id));
    }

}
