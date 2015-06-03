package org.easyquery.tests;

import org.easyquery.model.Contact;

import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class FromTest extends BaseTest {

    public FromTest(String name) {
        super(name);
    }

    public void testFromList() {
        List<Contact> list = easyQuery.from(Contact.class).list();
        assertEquals(2, list.size());
    }

    public void testFromUniqueResult() {
        Contact contact = easyQuery.from(Contact.class).where("contactId").equal(1).uniqueResult();
        assertEquals(new Integer(1), contact.getContactId());
        assertEquals("Nacho", contact.getName());
    }
}
