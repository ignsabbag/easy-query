package com.ignsabbag.hibernate.tests;

import com.ignsabbag.hibernate.EasyQuery;
import com.ignsabbag.hibernate.util.HibernateUtil;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;

import java.io.FileInputStream;

/**
 * Created by nacho on 21/05/15.
 */
public abstract class BaseTest extends DBTestCase {

    protected EasyQuery easyQuery;
    protected SessionFactory sessionFactory;

    public BaseTest(String name) {
        super( name );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:mem:test" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
        // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "" );
    }

    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset.xml"));
    }

    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.REFRESH;
    }

    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
    }

    public void setUp() throws Exception {
        sessionFactory = HibernateUtil.getSessionFactory();
        easyQuery = new EasyQuery(sessionFactory);
        super.setUp();
        //getConnection().createDataSet();
        sessionFactory.getCurrentSession().beginTransaction();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
}