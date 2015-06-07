/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
