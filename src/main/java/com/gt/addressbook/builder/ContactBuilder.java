package com.gt.addressbook.builder;

import com.gt.addressbook.model.Contact;
import com.gt.addressbook.model.Contact.Gender;
import java.util.Date;

/**
 *
 * @author jose
 */
public class ContactBuilder {

    private String name;
    private Date dateOfBirth;
    private Gender gender;

    private ContactBuilder() {
    }

    public static ContactBuilder aContact() {
        return new ContactBuilder();
    }

    public ContactBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public ContactBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Contact build() {
        return new Contact(name, dateOfBirth, gender);
    }
}
