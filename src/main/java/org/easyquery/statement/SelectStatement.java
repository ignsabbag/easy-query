package org.easyquery.statement;

import org.easyquery.query.Query;
import org.hibernate.Session;

/**
 * Created by nacho on 16/05/15.
 */
 public final class SelectStatement<T> extends Statement<T> {

    protected SelectStatement(Query<T> query) {
        super(query);
    }

    public SelectStatement(Session session, Class<T> clazz, String[] params, Boolean distinct) {
        super(session, clazz);
        if(distinct)
            super.selectDistinct(clazz, params);
        else
            super.select(clazz, params);
    }

    public FromStatement<T> from(Class clazz) {
        return super.from(clazz, null);
    }

    @Override
    public FromStatement<T> from(Class clazz, String alias) {
        return super.from(clazz, alias);
    }

}
