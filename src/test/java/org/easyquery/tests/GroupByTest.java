package org.easyquery.tests;

import org.easyquery.model.Course;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class GroupByTest extends BaseTest {

    public GroupByTest(String name) {
        super(name);
    }

    public void testGroupByList() {
        List courses = easyQuery
                .select("count(*)", "teacher.id")
                .from(Course.class)
                .groupBy("teacher.id")
                .orderBy("teacher.id")
                .list();
        assertEquals(2, courses.size());

        Iterator<Object[]> iterator = courses.iterator();
        assertEquals(2l, iterator.next()[0]);
        assertEquals(1l, iterator.next()[0]);
    }
}
