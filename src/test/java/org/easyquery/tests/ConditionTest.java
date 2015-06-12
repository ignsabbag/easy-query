package org.easyquery.tests;

import org.easyquery.model.Course;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class ConditionTest extends BaseTest {

    public ConditionTest(String name) {
        super(name);
    }

    public void testEqual() {
        Course course = easyQuery.from(Course.class).where("id").equal(1).uniqueResult();
        assertEquals(new Integer(1), course.getId());
    }

    public void testLike() {
        Course course = easyQuery.from(Course.class).where("name").like("%2").uniqueResult();
        assertEquals(new Integer(2), course.getId());
    }

    public void testBetween() {
        List<Course> courses = easyQuery.from(Course.class).where("id").between(1, 2).list();
        assertEquals(2, courses.size());
        Iterator<Course> iterator = courses.iterator();
        assertEquals(new Integer(1), iterator.next().getId());
        assertEquals(new Integer(2), iterator.next().getId());
    }

    public void testGreater() {
        List<Course> courses = easyQuery.from(Course.class).where("id").greater(2).list();
        assertEquals(1, courses.size());
        Iterator<Course> iterator = courses.iterator();
        assertEquals(new Integer(3), iterator.next().getId());
    }

    public void testGreaterOrEqual() {
        List<Course> courses = easyQuery.from(Course.class).where("id").greaterOrEqual(2).list();
        assertEquals(2, courses.size());
        Iterator<Course> iterator = courses.iterator();
        assertEquals(new Integer(2), iterator.next().getId());
        assertEquals(new Integer(3), iterator.next().getId());
    }

    public void testLess() {
        List<Course> courses = easyQuery.from(Course.class).where("id").less(2).list();
        assertEquals(1, courses.size());
        Iterator<Course> iterator = courses.iterator();
        assertEquals(new Integer(1), iterator.next().getId());
    }

    public void testLessOrEqual() {
        List<Course> courses = easyQuery.from(Course.class).where("id").lessOrEqual(2).list();
        assertEquals(2, courses.size());
        Iterator<Course> iterator = courses.iterator();
        assertEquals(new Integer(1), iterator.next().getId());
        assertEquals(new Integer(2), iterator.next().getId());
    }
}
