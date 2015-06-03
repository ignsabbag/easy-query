package org.easyquery.statement;

import org.easyquery.query.Query;

/**
 * Created by nacho on 16/05/15.
 */
public final class GroupByStatement<T> extends Statement<T> {

    protected GroupByStatement(Query<T> query) {
        super(query);
    }

    @Override
    public  Condition<HavingStatement<T>, T> having(String expr) {
        return super.having(expr);
    }

    @Override
    public OrderByStatement<T> orderBy(String ... params) {
        return super.orderBy(params);
    }

}
