package com.ignsabbag.hibernate.statement;

import com.ignsabbag.hibernate.query.Query;
import com.ignsabbag.hibernate.query.SqlQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by nacho on 16/05/15.
 */
abstract class Statement<T> {

    private Query<T> query;

    protected Statement(Query<T> query) {
        this.query = query;
    }

    protected Statement(Session session, Class<T> clazz) {
        this.query = new SqlQuery<T>(session, clazz);
    }

    protected FromStatement<T> from(Class<T> clazz, String alias) {
        this.query.from(clazz, alias);
        return new FromStatement<T>(this.query);
    }

    protected FromStatement<T> innerJoin(String expr, String alias) {
        this.query.innerJoin(expr, alias);
        return new FromStatement<T>(this.query);
    }

    protected Condition<WhereStatement<T>, T> where(String expr) {
        this.query.where(expr);
        WhereStatement<T> where = new WhereStatement<T>(this.query);
        return new Condition<WhereStatement<T>, T>(where);
    }

    protected <Q extends Statement<T>> Condition<Q, T> and(String expr) {
        this.query.and(expr);
        return new Condition<Q, T>((Q) this);
    }

    protected GroupByStatement<T> groupBy(String[] params) {
        this.query.groupBy(params);
        return new GroupByStatement<T>(this.query);
    }

    protected Condition<HavingStatement<T>, T> having(String expr) {
        this.query.having(expr);
        HavingStatement<T> having = new HavingStatement<T>(this.query);
        return new Condition<HavingStatement<T>, T>(having);
    }

    protected OrderByStatement<T> orderBy(String[] params) {
        this.query.orderBy(params);
        return new OrderByStatement<T>(this.query);
    }

    protected FinalStatement<T> asc() {
        this.query.asc();
        return new FinalStatement<T>(this.query);
    }

    protected FinalStatement<T> desc() {
        this.query.desc();
        return new FinalStatement<T>(this.query);
    }

    protected <Q extends Statement<T>> Q equal(Object param) {
        this.query.equal(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q like(Object param) {
        this.query.like(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q greater(Object param) {
        this.query.greater(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q greaterOrEqual(Object param) {
        this.query.greaterOrEqual(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q less(Object param) {
        this.query.less(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q lessOrEqual(Object param) {
        this.query.lessOrEqual(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q between(Object param1, Object param2) {
        this.query.between(param1, param2);
        return (Q) this;
    }

    @Override
    public String toString() {
        return this.query.toString();
    }

    public List<T> list() {
        return this.query.getQuery().list();
    }

    public T uniqueResult() {
        return (T) this.query.getQuery().uniqueResult();
    }

}
