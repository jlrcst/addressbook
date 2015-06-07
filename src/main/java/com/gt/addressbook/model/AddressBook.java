package com.gt.addressbook.model;

import java.util.HashMap;

/**
 *
 * @author jose
 */
public interface AddressBook {
    
    public int getFemales();
    
    public int getMales();
    
    public Contact getOldest();
    
    public int getDaysOlder(String name1, String name2);
            
    public HashMap<String, Contact> getContacts();
    
    public void addContact(Contact contact);
    
    public void removeContact(String contactName);
    
}
