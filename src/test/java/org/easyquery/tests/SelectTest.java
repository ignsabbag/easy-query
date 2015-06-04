package org.easyquery.tests;

import org.easyquery.model.Contact;

import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class SelectTest extends BaseTest {

    public SelectTest(String name) {
        super(name);
    }

    public void testSelectList() {
        List list = easyQuery.select("contact").from(Contact.class, "contact").list();
        assertEquals(2, list.size());
    }

    public void testSelectOneColumn() {
        String contactName = (String) easyQuery.select("name")
                .from(Contact.class).where("contactId").equal(1).uniqueResult();
        assertEquals("Nacho", contactName);
    }

    public void testSelectTwoColumns() {
        Object[] result = (Object[]) easyQuery.select("contactId", "name")
                .from(Contact.class).where("contactId").equal(1).uniqueResult();
        assertEquals("Nacho", result[1]);
    }
}
