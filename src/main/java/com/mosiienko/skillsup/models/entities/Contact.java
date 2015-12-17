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
        @NamedQuery(name = "getAllContacts", query = "SELECT a FROM Contact a"),
        @NamedQuery(name = "deleteContactById", query = "DELETE FROM Contact a WHERE a.id = :id")
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
    public String toString() {
        return name +
                " " + secondName +
                " " + age +
                " " + phone +
                "\n";
    }
}
