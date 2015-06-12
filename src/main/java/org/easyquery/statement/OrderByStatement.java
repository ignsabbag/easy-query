package org.easyquery.statement;

import org.easyquery.query.Query;

import java.util.List;

/**
 * Created by nacho on 16/05/15.
 */
public final class OrderByStatement<T> extends Statement<T> {

    protected OrderByStatement(Query<T> query) {
        super(query);
    }

    @Override
    public FinalStatement<T> asc() {
        return super.asc();
    }

    @Override
    public FinalStatement<T> desc() {
        return super.desc();
    }

    @Override
    public List<T> list() {
        super.asc();
        return super.list();
    }
}
