package com.gt.addressbook.comparator;


import com.gt.addressbook.model.Contact;
import java.util.Comparator;

/**
 *
 * @author jose
 */
public class ContactComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
    }

}
