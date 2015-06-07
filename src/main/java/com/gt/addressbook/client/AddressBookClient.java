package com.gt.addressbook.client;

import com.gt.addressbook.factory.AbstractAddressBookCreator;
import com.gt.addressbook.factory.SimpleAddressBookCreator;
import com.gt.addressbook.model.AddressBook;
import com.gt.addressbook.model.Contact;
import com.gt.addressbook.parser.FileParser;
import java.util.List;

/**
 *
 * @author jose
 */
public class AddressBookClient {

    public static void main(String[] args) {

        //Parse contacts from file
        FileParser fileParser = new FileParser();
        //System.out.println(AddressBookClient.class.getResource("/AddressBook").getPath());
        List<Contact> contacts = fileParser.getContactsFromFile(AddressBookClient.class.getResource("/AddressBook"));

        //Create AddressBook
        AbstractAddressBookCreator addressBookCreator = new SimpleAddressBookCreator();
        AddressBook addressBook = addressBookCreator.createAddressBook();

        //Add contacts to the addressbook
        contacts.stream().forEach((contact) -> {
            addressBook.addContact(contact);
        });

        //Print results
        System.out.println("Gumtree Coding Challenge Results.");
        System.out.println("There are " + addressBook.getMales() + " males in the address book.");
        System.out.println(addressBook.getOldest().getName() + " is the oldest person in the address book.");
        System.out.println("Bill is " + addressBook.getDaysOlder("Bill McKnight", "Paul Robinson") + " days older than Paul.");
    }

}
