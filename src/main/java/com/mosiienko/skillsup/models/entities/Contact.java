package com.mosiienko.skillsup.models.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@link Contact
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 02.12.15
 */
@Table(name = "contacts")
@Entity
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT a FROM Contact a"),
        @NamedQuery(name = "deleteById", query = "DELETE FROM Contact a WHERE a.id = :id")
})
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String secondName;

    private int age;

    private String phone;


    public int getId() {
        return id;
    }

    public Contact setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public Contact setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Contact setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (age != contact.age) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (secondName != null ? !secondName.equals(contact.secondName) : contact.secondName != null) return false;
        return !(phone != null ? !phone.equals(contact.phone) : contact.phone != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
