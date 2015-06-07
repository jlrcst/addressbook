package com.gt.addressbook.strategy;

import com.gt.addressbook.model.Contact;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author jose
 */
public class SimpleCompareAgeStrategy implements CompareAgeStrategy {

    @Override
    public int getDaysOlder(Contact contact1, Contact contact2) {
        LocalDate date1 = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(contact1.getDateOfBirth().getTime()), ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(contact2.getDateOfBirth().getTime()), ZoneId.systemDefault()).toLocalDate();
        return (int) date1.until(date2, DAYS);
    }
    
}
