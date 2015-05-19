package com.ignsabbag.hibernate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp() {
        String sql = new EasyQuery((Session) null).from(String.class, "s")
                .innerJoin("s.lili", "l")
                .where("lala").between("la", "la")
                .and("lolo").equal("lo").groupBy("lale")
                .having("lele").greater("le")
                .orderBy("lala", "lolo").asc().toString();
        System.out.println(sql);
        assertEquals("FROM java.lang.String AS s INNER JOIN s.lili AS l WHERE lala BETWEEN 'la' AND 'la' " +
                "AND lolo = 'lo' GROUP BY lale HAVING lele > 'le' ORDER BY lala, lolo ASC", sql);
    }
}
