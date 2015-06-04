package org.easyquery.query;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by nacho on 17/05/15.
 */
public abstract class Query<T> {

    protected Session session;
    protected Class<T> clazz;

    public Query(Session session, Class<T> clazz) {
        this.session = session;
        this.clazz = clazz;
    }

    public abstract void select(String[] params);

    public abstract void selectDistinct(String[] params);

    public abstract void from(Class<T> clazz, String alias);

    public abstract void innerJoin(String expr, String alias);

    public abstract void where(String expr);

    public abstract void and(String expr);

    public abstract void groupBy(String[] params);

    public abstract void having(String expr);

    public abstract void orderBy(String[] params);

    public abstract void asc();

    public abstract void desc();

    /* Conditions */

    public abstract void equal(Object param);

    public abstract void like(Object param);

    public abstract void greater(Object param);

    public abstract void greaterOrEqual(Object param);

    public abstract void less(Object param);

    public abstract void lessOrEqual(Object param);

    public abstract void between(Object param1, Object param2);

    public abstract List<T> list();

    public abstract T uniqueResult();

}
