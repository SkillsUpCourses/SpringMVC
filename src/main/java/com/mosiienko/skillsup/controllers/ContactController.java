package com.mosiienko.skillsup.controllers;

import com.mosiienko.skillsup.models.dto.ContactDto;
import com.mosiienko.skillsup.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Class {@link ContactController}
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 30.12.15
 */
@RequestMapping(value = "/contact")
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public List<ContactDto> addContact(@RequestBody ContactDto contactDto) {
        contactService.add(contactDto);
        return contactService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactDto> getAllContacts() {
        return contactService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteContact(@PathVariable(value = "id") int id) {
         contactService.delete(id);
    }

}
