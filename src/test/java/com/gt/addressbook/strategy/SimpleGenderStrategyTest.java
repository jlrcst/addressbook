package com.gt.addressbook.strategy;

import com.gt.addressbook.builder.ContactBuilder;
import com.gt.addressbook.model.Contact;
import com.gt.addressbook.model.ContactOperation;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class SimpleGenderStrategyTest {

    private SimpleGenderStrategy simpleGenderStrategy;

    @Before
    public void setUp() {
        this.simpleGenderStrategy = new SimpleGenderStrategy();
    }

    /**
     * Test of numOfFemales method, of class SimpleGenderStrategy.
     */
    @Test
    public void testNumOfFemales() {

        //given
        Contact contact1 = ContactBuilder.aContact()
                .withName("name1")
                .withDateOfBirth(new Date(100L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        Contact contact2 = ContactBuilder.aContact()
                .withName("name2")
                .withDateOfBirth(new Date(50L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        Contact contact3 = ContactBuilder.aContact()
                .withName("name3")
                .withDateOfBirth(new Date(100L))
                .withGender(Contact.Gender.MALE)
                .build();
        Contact contact4 = ContactBuilder.aContact()
                .withName("name4")
                .withDateOfBirth(new Date(50L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        this.simpleGenderStrategy.handleRequest(contact1, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact2, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact3, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact4, ContactOperation.ADD);        
        int expResult = 3;

        //when
        int result = this.simpleGenderStrategy.numOfFemales();
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of numOfMales method, of class SimpleGenderStrategy.
     */
    @Test
    public void testNumOfMales() {
        
        //given
        Contact contact1 = ContactBuilder.aContact()
                .withName("name1")
                .withDateOfBirth(new Date(100L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        Contact contact2 = ContactBuilder.aContact()
                .withName("name2")
                .withDateOfBirth(new Date(50L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        Contact contact3 = ContactBuilder.aContact()
                .withName("name3")
                .withDateOfBirth(new Date(100L))
                .withGender(Contact.Gender.MALE)
                .build();
        Contact contact4 = ContactBuilder.aContact()
                .withName("name4")
                .withDateOfBirth(new Date(50L))
                .withGender(Contact.Gender.FEMALE)
                .build();
        this.simpleGenderStrategy.handleRequest(contact1, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact2, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact3, ContactOperation.ADD);
        this.simpleGenderStrategy.handleRequest(contact4, ContactOperation.ADD);        
        int expResult = 1;

        //when
        int result = this.simpleGenderStrategy.numOfMales();
        
        //then
        assertEquals(expResult, result);
    }

}
