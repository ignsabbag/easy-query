package org.easyquery.statement;

import org.easyquery.query.Query;

/**
 * Created by nacho on 16/05/15.
 */
public final class WhereStatement<T> extends Statement<T> {

    protected WhereStatement(Query<T> query) {
        super(query);
    }

    @Override
    public Condition<WhereStatement<T>, T> and(String expr) {
        return super.and(expr);
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
