/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksu.skillsup.models;

import com.ksu.skillsup.entities.MappedHobby;

/**
 *
 * @author ksu
 */
public class Hobby {
    
    private String hobbyName;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
    
    public Hobby (MappedHobby mappedHobby) {
        this.hobbyName=mappedHobby.getHobbyName();
    }
}
