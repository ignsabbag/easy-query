package org.easyquery.statement;

import org.easyquery.query.Query;

/**
 * Created by nacho on 16/05/15.
 */
public final class HavingStatement<T> extends Statement<T> {

    protected HavingStatement(Query<T> query) {
        super(query);
    }

    @Override
    public Condition<HavingStatement<T>, T> and(String expr) {
        return super.and(expr);
    }

    @Override
    public OrderByStatement<T> orderBy(String ... params) {
        return super.orderBy(params);
    }
}
