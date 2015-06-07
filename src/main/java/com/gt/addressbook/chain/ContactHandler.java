package com.gt.addressbook.chain;

import com.gt.addressbook.model.Contact;
import com.gt.addressbook.model.ContactOperation;



/**
 * The ContactHandler is the interface to implement a Chain of Responsibility design pattern.
 * 
 * @author jose
 */
public interface ContactHandler {

    public void setNext(ContactHandler handler);

    public void handleRequest(Contact contact, ContactOperation operation);

}
