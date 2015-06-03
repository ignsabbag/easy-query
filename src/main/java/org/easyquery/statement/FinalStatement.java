package org.easyquery.statement;

import org.easyquery.query.Query;

/**
 * Created by nacho on 16/05/15.
 */
public final class FinalStatement<T> extends Statement<T> {

    public FinalStatement(Query<T> query) {
        super(query);
    }
}
