package org.easyquery.tests;

import org.easyquery.model.Course;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class OrderByTest extends BaseTest {

    public OrderByTest(String name) {
        super(name);
    }

    public void testOrderList() {
        List<Course> list = easyQuery.from(Course.class, "c").orderBy("c.teacher.id").list();
        assertEquals(3, list.size());
        Iterator<Course> iterator = list.iterator();
        assertEquals(new Integer(1), iterator.next().getTeacher().getId());
        assertEquals(new Integer(1), iterator.next().getTeacher().getId());
        assertEquals(new Integer(2), iterator.next().getTeacher().getId());
    }

    public void testOrderDescList() {
        List<Course> list = easyQuery.from(Course.class).orderBy("id").desc().list();
        assertEquals(3, list.size());
        Iterator<Course> iterator = list.iterator();
        assertEquals(new Integer(3), iterator.next().getId());
        assertEquals(new Integer(2), iterator.next().getId());
        assertEquals(new Integer(1), iterator.next().getId());
    }
}
