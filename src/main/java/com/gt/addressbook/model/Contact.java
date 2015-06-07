/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.addressbook.model;

import java.util.Date;

/**
 *
 * @author jose
 */
public class Contact {

    public enum Gender {

        FEMALE,
        MALE;
    }

    private final String name;
    private final Date dateOfBirth;
    private final Gender gender;

    public Contact(String name, Date dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

}
