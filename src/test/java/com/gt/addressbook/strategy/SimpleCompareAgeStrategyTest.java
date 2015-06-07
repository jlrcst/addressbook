package com.gt.addressbook.strategy;

import com.gt.addressbook.builder.ContactBuilder;
import com.gt.addressbook.model.Contact;
import java.time.LocalDate;
import static java.time.Month.JANUARY;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class SimpleCompareAgeStrategyTest {

    private SimpleCompareAgeStrategy simpleCompareAgeStrategy;

    @Before
    public void setUp() {
        this.simpleCompareAgeStrategy = new SimpleCompareAgeStrategy();
    }

    /**
     * Test of getDaysOlder method, of class SimpleCompareAgeStrategy.
     */
    @Test
    public void testGetDaysOlder() {

        //given
        Contact contact1 = ContactBuilder.aContact()
                .withName("name1")
                .withDateOfBirth(Date.from(
                                LocalDate.of(1980, JANUARY, 10)
                                .atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant()))
                .withGender(Contact.Gender.FEMALE)
                .build();
        Contact contact2 = ContactBuilder.aContact()
                .withName("name2")
                .withDateOfBirth(Date.from(
                                LocalDate.of(1980, JANUARY, 20)
                                .atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant()))
                .withGender(Contact.Gender.FEMALE)
                .build();
        int expResult = 10;

        //when
        int result = this.simpleCompareAgeStrategy.getDaysOlder(contact1, contact2);

        //then
        assertEquals(expResult, result);
    }

}
