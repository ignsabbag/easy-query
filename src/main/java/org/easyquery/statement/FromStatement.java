package org.easyquery.statement;

import org.easyquery.query.Query;
import org.hibernate.Session;

/**
 * Created by nacho on 16/05/15.
 */
 public final class FromStatement<T> extends Statement<T> {

    protected FromStatement(Query<T> query) {
        super(query);
    }

    public FromStatement(Session session, Class<T> clazz, String alias) {
        super(session, clazz);
        super.from(clazz, alias);
    }

    public FromStatement<Object[]> innerJoin(String expr) {
        return this.innerJoin(expr, null);
    }

    @Override
    public FromStatement<Object[]> innerJoin(String expr, String alias) {
        return super.innerJoin(expr, alias);
    }

    @Override
    public Condition<WhereStatement<T>, T> where(String expr) {
        return super.where(expr);
    }

    @Override
    public GroupByStatement<T> groupBy(String ... params) {
        return super.groupBy(params);
    }

    @Override
    public OrderByStatement<T> orderBy(String ... params) {
        return super.orderBy(params);
    }
}
