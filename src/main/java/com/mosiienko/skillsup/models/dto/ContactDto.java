package com.mosiienko.skillsup.models.dto;

/**
 * Class {@link ContactDto
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 23.12.15
 */
public class ContactDto {

    private String name;

    private String secondName;

    private int age;

    private String phone;

    private int id;

    public ContactDto(String name, String secondName, int age, String phone, int id) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
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
