package com.ignsabbag.hibernate.statement;

/**
 * Created by nacho on 17/05/15.
 */
public final class Condition<Q extends Statement<T>, T> {

    protected Q query;

    public Condition(Q query) {
        this.query = query;
    }

    public Q equal(Object param) {
        return (Q) query.equal(param);
    }

    public Q like(Object param) {
        return (Q) query.like(param);
    }

    public Q greater(Object param) {
        return (Q) query.greater(param);
    }

    public Q greaterOrEqual(Object param) {
        return (Q) query.greaterOrEqual(param);
    }

    public Q less(Object param) {
        return (Q) query.less(param);
    }

    public Q lessOrEqual(Object param) {
        return (Q) query.lessOrEqual(param);
    }

    public Q between(Object param1, Object param2) {
        return (Q) query.between(param1, param2);
    }
}
