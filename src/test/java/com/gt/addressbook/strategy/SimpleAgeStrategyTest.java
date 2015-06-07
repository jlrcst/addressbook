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
public class SimpleAgeStrategyTest {

    private SimpleAgeStrategy simpleAgeStrategy;

    @Before
    public void setUp() {
        this.simpleAgeStrategy = new SimpleAgeStrategy();
    }

    /**
     * Test of getOlder method, of class SimpleAgeStrategy.
     */
    @Test
    public void testGetOlder() {

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
        this.simpleAgeStrategy.handleRequest(contact1, ContactOperation.ADD);
        this.simpleAgeStrategy.handleRequest(contact2, ContactOperation.ADD);
        String expResult = "name2";

        //when
        Contact result = this.simpleAgeStrategy.getOlder();

        //then
        assertEquals(expResult, result.getName());
    }

}
