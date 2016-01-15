/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksu.skillsup.entities;

import com.ksu.skillsup.models.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author ksu
 */
@Entity
@Table(name="contacts")
public class MappedContact implements Comparable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    
    @Column(name="CONTACT_NAME", length=100, nullable=false)
    private String firstName;
    
    @Column(name="CONTACT_SURNAME", length=100, nullable=false)
    private String lastName;
    
    @Column(name="CONTACT_PHONE", length=100, nullable=false)
    private String phone;
    
    @Column(name="CONTACT_EMAIL", length=100, nullable=false)
    private String email;
    
    @ManyToOne(cascade = { CascadeType.ALL })  
    private MappedHobby hobby;
    
    public MappedContact() {
    }
 
    public MappedContact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    
        public MappedContact(String firstName, String lastName, String phone, String email, MappedHobby hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.hobby = hobby;
    }
    
    public MappedContact(Long id, String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.id=id;
    }
    
    public MappedContact(ResultSet result) throws SQLException {
        this.setFirstName(result.getString(1));
        this.setLastName(result.getString(2));
        this.setPhone(result.getString(3));
        this.setEmail(result.getString(4));
        this.setHobby(result.getObject(5, MappedHobby.class));
    }
    
    public MappedContact(Contact contact) {
        this.setFirstName(contact.getFirstName());
        this.setLastName(contact.getLastName());
        this.setPhone(contact.getPhone());
        this.setEmail(contact.getEmail());
    }
 
        
    public long getID() {
        return id;
    }
 
    public void setID (Long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public MappedHobby getHobby() {
        return hobby;
    }
 
    public void setHobby(MappedHobby hobby) {
        this.hobby = hobby;
    }
 
    @Override
    public String toString() {
        return "Contact {firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + "}";
    }

    @Override
    public int compareTo(Object o) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), o.toString());
    }
    
    @Override
    public boolean equals(Object obj) {
        return (this.toString().equalsIgnoreCase(obj.toString()))? true : false;  
    }
    

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}