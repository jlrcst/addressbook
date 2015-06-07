package com.gt.addressbook.model;

import java.util.HashMap;

/**
 *
 * @author jose
 */
public interface AddressBook {
    
    public int getFemales();
    
    public int getMales();
    
    public Contact getOlder();
    
    public HashMap<String, Contact> getContacts();
    
    public void addContact(Contact contact);
    
    public void removeContact(String contactName);
    
}
