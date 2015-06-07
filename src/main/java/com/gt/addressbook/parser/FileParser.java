package com.gt.addressbook.parser;

import com.gt.addressbook.model.Contact;
import com.gt.addressbook.model.Contact.Gender;
import static com.gt.addressbook.model.Contact.Gender.FEMALE;
import static com.gt.addressbook.model.Contact.Gender.MALE;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author jose
 */
public class FileParser {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public List<Contact> getContactsFromFile(URL url) {
        List<Contact> contacts = new ArrayList<>();
        try {
            final Map<String, String> env = new HashMap<>();
            final String[] array = url.toURI().toString().split("!");
            final FileSystem fs = FileSystems.newFileSystem(url.toURI().create(array[0]), env);
            final Path path = fs.getPath(array[1]);
            try (Stream<String> stream = Files.lines(path)) {
                stream.forEach((Object t) -> {
                    String line = (String) t;
                    String[] values = line.split(",");
                    try {
                        contacts.add(new Contact(values[0], parseDate(values[2]), parseGender(values[1])));
                    } catch (ParseException ex) {
                        java.util.logging.Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contacts;
    }

    private Date parseDate(String stringDate) throws ParseException {
        return sdf.parse(stringDate.trim());
    }

    private Gender parseGender(String stringGender) {
        switch (stringGender.trim()) {
            case "Male":
                return MALE;
            case "Female":
                return FEMALE;
            default:
                throw new AssertionError();
        }
    }

}
