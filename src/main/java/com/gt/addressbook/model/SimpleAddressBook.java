package com.gt.addressbook.model;

import com.gt.addressbook.chain.ContactHandler;
import com.gt.addressbook.strategy.AgeStrategy;
import com.gt.addressbook.strategy.CompareAgeStrategy;
import com.gt.addressbook.strategy.GenderStrategy;
import com.gt.addressbook.strategy.SimpleCompareAgeStrategy;
import java.util.HashMap;

/**
 *
 * @author jose
 */
public class SimpleAddressBook implements AddressBook, ContactHandler {

    private final HashMap<String, Contact> contacts;

    private final GenderStrategy genderStrategy;

    private final AgeStrategy ageStrategy;

    private final CompareAgeStrategy compareAgeStrategy;

    private ContactHandler next;

    public SimpleAddressBook(GenderStrategy genderStrategy, AgeStrategy ageStrategy, SimpleCompareAgeStrategy compareAgeStrategy) {
        this.contacts = new HashMap<>();
        this.genderStrategy = genderStrategy;
        this.ageStrategy = ageStrategy;
        this.compareAgeStrategy = compareAgeStrategy;
    }

    @Override
    public int getFemales() {
        return this.genderStrategy.numOfFemales();
    }

    @Override
    public int getMales() {
        return this.genderStrategy.numOfMales();
    }

    @Override
    public Contact getOldest() {
        return this.ageStrategy.getOldest();
    }

    @Override
    public int getDaysOlder(String name1, String name2) {
        return this.compareAgeStrategy.getDaysOlder(this.contacts.get(name1), this.contacts.get(name1));
    }

    @Override
    public HashMap<String, Contact> getContacts() {
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        handleRequest(contact, ContactOperation.ADD);
    }

    @Override
    public void removeContact(String contactName) {
        handleRequest(contacts.get(contactName), ContactOperation.REMOVE);
    }

    @Override
    public void setNext(ContactHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Contact contact, ContactOperation operation) {
        switch (operation) {
            case ADD:
                this.contacts.put(contact.getName(), contact);
                break;
            case REMOVE:
                this.contacts.remove(contact.getName());
                break;
            default:
                throw new AssertionError();
        }
        this.next.handleRequest(contact, operation);
    }

}
