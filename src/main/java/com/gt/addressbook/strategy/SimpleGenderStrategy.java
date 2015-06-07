package com.gt.addressbook.strategy;

import com.gt.addressbook.chain.ContactHandler;
import com.gt.addressbook.model.Contact;
import static com.gt.addressbook.model.Contact.Gender.FEMALE;
import static com.gt.addressbook.model.Contact.Gender.MALE;
import com.gt.addressbook.model.ContactOperation;
import static com.gt.addressbook.model.ContactOperation.ADD;
import static com.gt.addressbook.model.ContactOperation.REMOVE;


/**
 *
 * @author jose
 */
public class SimpleGenderStrategy implements GenderStrategy, ContactHandler {

    private int numberOfMales;

    private int numberOfFemales;

    private ContactHandler next;

    @Override
    public int numOfFemales() {
        return this.numberOfFemales;
    }

    @Override
    public int numOfMales() {
        return this.numberOfMales;
    }

    @Override
    public void setNext(ContactHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Contact contact, ContactOperation contactOperation) {
        switch (contactOperation) {
            case ADD:
                switch (contact.getGender()) {
                    case FEMALE:
                        this.numberOfFemales++;
                        break;
                    case MALE:
                        this.numberOfMales++;
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            case REMOVE:
                switch (contact.getGender()) {
                    case FEMALE:
                        this.numberOfFemales--;
                        break;
                    case MALE:
                        this.numberOfMales--;
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            default:
                throw new AssertionError();
        }
        if (this.next != null) {
            this.next.handleRequest(contact, contactOperation);
        }
    }

}
