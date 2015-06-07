package com.gt.addressbook.strategy;

import com.gt.addressbook.model.Contact;

/**
 *
 * @author jose
 */
public interface CompareAgeStrategy {

    public int getDaysOlder(Contact contact1, Contact contact2);

}
