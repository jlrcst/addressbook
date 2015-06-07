/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        List<Contact> contacts = fileParser.getContactsFromFile(AddressBookClient.class.getClassLoader().getResource("AddressBook").getPath());
        
        //Create AddressBook
        AbstractAddressBookCreator addressBookCreator = new SimpleAddressBookCreator();
        AddressBook addressBook = addressBookCreator.createAddressBook();
        
        //Add contacts to the addressbook
        contacts.stream().forEach((contact) -> {
            addressBook.addContact(contact);
        });
        
        //Print results
        System.out.println("Males are in the address book " + addressBook.getMales());
        System.out.println("Oldest person in the address book " + addressBook.getOldest().getName());
        System.out.println("Bill is " + addressBook.getDaysOlder("Bill McKnight", "Paul Robinson") + " days older than Paul");
    }

}
