package com.gt.addressbook.model;

import com.gt.addressbook.builder.ContactBuilder;
import com.gt.addressbook.factory.AbstractAddressBookCreator;
import com.gt.addressbook.factory.SimpleAddressBookCreator;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class SimpleAddressBookTest {
    
    private SimpleAddressBook simpleAddressBook;
    
    public SimpleAddressBookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        AbstractAddressBookCreator addressBookCreator = new SimpleAddressBookCreator();
        this.simpleAddressBook = (SimpleAddressBook) addressBookCreator.createAddressBook();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFemales method, of class SimpleAddressBook.
     */
    @Test
    public void testGetFemales() {

        //Given
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
        this.simpleAddressBook.addContact(contact1);
        this.simpleAddressBook.addContact(contact2);
        this.simpleAddressBook.addContact(contact3);
        int expectedResult = 2;

        //when
        int result = this.simpleAddressBook.getFemales();

        //then
        assertEquals(expectedResult, result);        
    }

    /**
     * Test of getMales method, of class SimpleAddressBook.
     */
    @Test
    public void testGetMales() {

        //Given
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
        this.simpleAddressBook.addContact(contact1);
        this.simpleAddressBook.addContact(contact2);
        this.simpleAddressBook.addContact(contact3);
        int expectedResult = 1;

        //when
        int result = this.simpleAddressBook.getMales();

        //then
        assertEquals(expectedResult, result);        
    }

    /**
     * Test of getOldest method, of class SimpleAddressBook.
     */
    @Test
    public void testGetOldest() {

        //Given
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
        this.simpleAddressBook.addContact(contact1);
        this.simpleAddressBook.addContact(contact2);
        this.simpleAddressBook.addContact(contact3);
        String expectedName = "name2";

        //when
        Contact result = this.simpleAddressBook.getOldest();

        //then
        assertEquals(expectedName, result.getName());
    }

    /**
     * Test of addContact method, of class SimpleAddressBook.
     */
    @Test
    public void testAddContact() {

        //Given
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
        int expectedSize = 3;

        //when
        this.simpleAddressBook.addContact(contact1);
        this.simpleAddressBook.addContact(contact2);
        this.simpleAddressBook.addContact(contact3);

        //then
        assertEquals(expectedSize, this.simpleAddressBook.getContacts().size());
    }

    /**
     * Test of removeContact method, of class SimpleAddressBook.
     */
    @Test
    public void testRemoveContact() {

        //Given
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
        this.simpleAddressBook.addContact(contact1);
        this.simpleAddressBook.addContact(contact2);
        this.simpleAddressBook.addContact(contact3);
        int expectedSize = 2;

        //when
        this.simpleAddressBook.removeContact(contact2.getName());

        //then
        assertEquals(expectedSize, this.simpleAddressBook.getContacts().size());
    }
    
}
