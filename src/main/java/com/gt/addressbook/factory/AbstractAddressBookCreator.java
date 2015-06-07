package com.gt.addressbook.factory;

import com.gt.addressbook.model.AddressBook;

/**
 *
 * @author jose
 */
public abstract class AbstractAddressBookCreator {

    public abstract AddressBook createAddressBook();

    public AddressBook getAddressBook() {
        AddressBook addressBook = createAddressBook();
        return addressBook;
    }

}
