package org.easyquery.tests;

import org.easyquery.model.Course;

/**
 * Created by nacho on 21/05/15.
 */
public class HavingTest extends BaseTest {

    public HavingTest(String name) {
        super(name);
    }

    public void testGroupByList() {
        Object[] result = (Object[]) easyQuery
                .select("count(*)", "teacher.id")
                .from(Course.class)
                .groupBy("teacher.id")
                .having("teacher.id").greater(1)
                .uniqueResult();

        assertEquals(2, result[1]);
    }
}
