package com.gt.addressbook.strategy;

import com.gt.addressbook.chain.ContactHandler;
import com.gt.addressbook.comparator.ContactComparator;
import com.gt.addressbook.model.Contact;
import com.gt.addressbook.model.ContactOperation;
import static com.gt.addressbook.model.ContactOperation.ADD;
import static com.gt.addressbook.model.ContactOperation.REMOVE;
import java.util.PriorityQueue;

/**
 *
 * @author jose
 */
public class SimpleAgeStrategy implements AgeStrategy, ContactHandler {

    private final PriorityQueue<Contact> queue;    
    private ContactHandler next;

    public SimpleAgeStrategy() {
        this.queue = new PriorityQueue<>(new ContactComparator());
    }

    @Override
    public Contact getOldest() {
        return this.queue.peek();
    }

    @Override
    public void setNext(ContactHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Contact contact, ContactOperation operation) {
        switch (operation) {
            case ADD:
                this.queue.add(contact);
                break;
            case REMOVE:
                this.queue.remove(contact);
                break;
            default:
                throw new AssertionError();
        }

        if (this.next != null) {
            this.handleRequest(contact, operation);
        }
    }

}
