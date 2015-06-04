package org.easyquery.tests;

import org.easyquery.model.Course;
import org.easyquery.model.Teacher;

import java.util.List;

/**
 * Created by nacho on 21/05/15.
 */
public class FromTest extends BaseTest {

    public FromTest(String name) {
        super(name);
    }

    public void testFromList() {
        List<Teacher> teachers = easyQuery.from(Teacher.class).list();
        assertEquals(2, teachers.size());

        List<Course> courses = easyQuery.from(Course.class).list();
        assertEquals(3, courses.size());
    }

    public void testFromUniqueResult() {
        Teacher teacher = easyQuery.from(Teacher.class).where("id").equal(1).uniqueResult();
        assertEquals(new Integer(1), teacher.getId());
        assertEquals("Nacho", teacher.getName());
    }
}
