package org.easyquery;

import org.easyquery.statement.FromStatement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by nacho on 17/05/15.
 */
public class EasyQuery {

    private Session session;

    private SessionFactory sessionFactory;

    public EasyQuery(Session session) {
        this.session = session;
    }

    public EasyQuery(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> FromStatement<T> from(Class<T> clazz) {
        return this.from(clazz, null);
    }

    public <T> FromStatement<T> from(Class<T> clazz, String alias) {
        return new FromStatement<T>(getCurrentSession(), clazz, alias);
    }

    protected Session getCurrentSession() {
        if( this.sessionFactory != null ) {
            return sessionFactory.getCurrentSession();
        } else {
            return session;
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
