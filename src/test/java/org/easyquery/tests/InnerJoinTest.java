package org.easyquery.tests;

import org.easyquery.model.Course;

import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class InnerJoinTest extends BaseTest {

    public InnerJoinTest(String name) {
        super(name);
    }

    public void testInnerJoinList() {
        List<Object[]> courses = easyQuery.from(Course.class, "c").innerJoin("c.teacher", "t").list();
        assertEquals(3, courses.size());
    }

    public void testInnerJoinUniqueResult() {
        Course course = (Course) easyQuery.from(Course.class, "c")
                .innerJoin("c.teacher", "t")
                .where("id").equal(1).uniqueResult()[0];
        assertEquals(new Integer(1), course.getId());
        assertEquals("Course 1", course.getName());
        assertEquals("Nacho", course.getTeacher().getName());
    }

    public void testCoursesFromTeacher1() {
        List<Object[]> courses = easyQuery.from(Course.class, "c")
                .innerJoin("c.teacher", "t")
                .where("t.id").equal(1).list();
        assertEquals(2, courses.size());
        assertEquals("Nacho", ((Course) courses.get(0)[0]).getTeacher().getName());
    }
}
