package com.gt.addressbook.factory;

import com.gt.addressbook.model.AddressBook;
import com.gt.addressbook.model.SimpleAddressBook;
import com.gt.addressbook.strategy.SimpleAgeStrategy;
import com.gt.addressbook.strategy.SimpleGenderStrategy;

/**
 *
 * @author jose
 */
public class SimpleAddressBookCreator extends AbstractAddressBookCreator {

    @Override
    public AddressBook createAddressBook() {
        SimpleGenderStrategy genderStrategy = new SimpleGenderStrategy();
        SimpleAgeStrategy ageStrategy = new SimpleAgeStrategy();
        genderStrategy.setNext(ageStrategy);
        SimpleAddressBook addressBook = new SimpleAddressBook(genderStrategy, ageStrategy);
        addressBook.setNext(genderStrategy);
        return addressBook;
    }

}
